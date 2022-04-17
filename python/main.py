import json
from pathlib import Path

import numpy as np
import matplotlib.pyplot as plt
import random

def islands(roads):
    sets = []
    for road in roads.keys():
        found = False
        for i, set_ in enumerate(sets):
            if road[0] in set_ or road[1] in set_:
                set_.add(road[0])
                set_.add(road[1])
                sets[i] = set_
                found = True
                break
        if not found:
            sets.append({road[0], road[1]})
    removed = list()
    for i, set_i in enumerate(sets):
        for j in range(i + 1, len(sets)):
            set_j = sets[j]
            if set_i.intersection(set_j):
                sets[i] = set_i.union(set_j)
                removed.append(j)
    return [s for i, s in enumerate(sets) if i not in removed]


# returns the ith closest city
def closest_city(src, cities, i):
    dists = list()
    for target in cities:
        if target is not src:
            dists.append(np.linalg.norm([target['x'] - src['x']], target['y'] - src['y']))
        else:
            dists.append(float('inf'))
    dists = [(ind, x) for ind, x in enumerate(dists)]
    dists = sorted(dists, key=lambda x: x[1])
    ith_closest = dists[i][0]
    return cities[ith_closest]


def get_dist(src_city, dest_city):
    return ((src_city['x'] - dest_city['x']) ** 2 + (src_city['y'] - dest_city['y'])**2 ) ** 0.5


def generate_test(city_count, roads_per_city, test_case_num, canvas_size=10):
    out_path = Path('/Users/bradwindsor/teaching/projects/project-2/test/resources/')
    plt.figure().clear()
    plt.close()
    plt.cla()
    plt.clf()

    fig = plt.gcf()
    fig.clear()
    fig.set_size_inches(10, 10)
    # fig.set_dpi(int(canvas_size ** 0.5))


    cities = list()
    for i in range(city_count):
        cities.append({
            'CityNumber': i,
            'x': random.random() * canvas_size,
            'y': random.random() * canvas_size,
            'Name': f'City {i}',
        })

    roads = dict()
    for count in range(roads_per_city):
        for i, city in enumerate(cities):
            target_city = closest_city(city, cities, count)
            key = (city['CityNumber'], target_city['CityNumber'])
            key_rev = (target_city['CityNumber'], city['CityNumber'])
            if key_rev not in roads and key not in roads:
                roads[key] = {
                    'City1': city['CityNumber'],
                    'City2': target_city['CityNumber'],
                    'Name': 'Road {}-{}'.format(city['CityNumber'], target_city['CityNumber']),
                    'Dist': get_dist(city, target_city),
                    'Local': True,
                }

    # connect all islands in graph
    isl = islands(roads)
    if len(isl) > 1:
        start = list(isl[0])[0]
        for set_ in isl[1:]:
            end = list(set_)[0]
            roads[(start, end)] = {
                'City1': start,
                'City2': end,
                'Name': f'Highway {start}-{end}',
                'Dist': get_dist(cities[start], cities[end]),
                'Local': False
            }
            start = end

    # plot
    for road in roads.values():
        start = cities[road['City1']]
        end = cities[road['City2']]
        plt.plot([start['x'], end['x']], [start['y'], end['y']], 'ro-' if road['Local'] else 'bo-')
        mid_x = (start['x'] + end['x']) / 2
        mid_y = (start['y'] + end['y']) / 2
        plt.text(mid_x, mid_y, road['Name'])

    for city in cities:
        plt.text(city['x'], city['y'], city['CityNumber'])




    case_name = f'nodes-{city_count}-num-{test_case_num}'
    case_out = out_path / case_name
    case_out.mkdir()
    json.dump(list(roads.values()), open(str(case_out / 'roads.json'), 'w'), indent=4)
    json.dump(list(cities), open(str(case_out / 'cities.json'), 'w'), indent=4)
    plt.savefig(str(case_out / 'figure.png'))
    # plt.show()
    print('done')

if __name__ == '__main__':
    settings = [
        (4, 1, 10),
        (10, 2, 100),
        (100, 5, 1000)
    ]
    i = 0
    while i < 5:
        for nodes, connections, canvas in settings:
            generate_test(nodes, connections, i, canvas_size=canvas)
        i += 1
    # generate_test(10, 2, canvas_size=100)
