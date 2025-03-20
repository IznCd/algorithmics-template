import json
from helper import draw_coloured_map, generate_graph_map

colors = ["red", "blue", "green", "yellow", "orange", "purple", "cyan", "magenta", "lime"]

def greedy(graph):
    n_nodes = len(graph)
    visited_nodes = [False] * n_nodes
    final_colors = {}
    
    for i in range(n_nodes):
        if not visited_nodes[i]:
            DFS(graph, visited_nodes, i, final_colors)
    return final_colors


def DFS(graph, visited_nodes, node, final_colors):
    while node is not None:
        if not visited_nodes[node]:
            visited_nodes[node] = True

            neighbor_colors = set()
            for neighbor in graph[str(node)]:
                if str(neighbor) in final_colors:
                    neighbor_colors.add(final_colors[str(neighbor)])

            for color in colors:
                if color not in neighbor_colors:
                    final_colors[str(node)] = color
                    break

            for node_connected in graph[str(node)]:
                if not visited_nodes[node_connected]:
                    node = node_connected
                    break
            else:
                node = None
            
                    

if __name__ == "__main__":
    n = 128
    map = generate_graph_map(n)
    solution = greedy(map["graph"])

    if solution:
        print("Solution found:", solution)
        draw_coloured_map(map, solution)
        with open('solution.json', 'w') as f:
            json.dump(solution, f)
            f.close()
    else:
        print("Solution not found.")
