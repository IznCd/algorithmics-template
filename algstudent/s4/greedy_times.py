import os
import json
import time
from helper import draw_coloured_map, generate_graph_map
from graph_colouring import greedy

if __name__ == "__main__":
    results = []
    folder = "sols"
    
    for filename in os.listdir(folder):
        if filename.startswith('g') and filename.endswith('.json'):
            filepath = folder+"/"+filename
            with open(filepath, 'r') as f:
                map = json.load(f)
                f.close()
            
            graph = map["graph"]
            n = len(graph)

            start_time = time.time()

            for i in range(1000):
                solution = greedy(graph)

            end_time = time.time()

            elapsed = (end_time - start_time) * 1000
            results.append((filename, n, elapsed))

            results.sort(key=lambda x: x[1])

    print("File         | # Nodes | Time (seconds)")
    print("---------------------------------------")
    i = 1
    for (fname, n_nodes, t) in results:
        print(f"{i}. {fname:12s} | {n_nodes:7d} | {t:.6f}")
        i+=1
