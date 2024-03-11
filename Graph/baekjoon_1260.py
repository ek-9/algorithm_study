'''
input
4 5 1
1 2
1 3
1 4
2 4
3 4

output
1 2 4 3 #dfs
1 2 3 4 #bfs
'''

import sys
from collections import deque

input = sys.stdin.readline

# n : 정점의 개수
# m : 간선의 개수
# v : 시작 정점의 번호

n,m,v = map(int,input().split())
graph = [[] for _ in range(n+1)]

# 노드를 방문했는지 알아보기 위해 visited 배열 생성
# 값이 0이면 방문안함, 1이면 방문함
visitedDfs = [0 for _ in range(n+1)]
visitedBfs = [0 for _ in range(n+1)]

# 그래프 만들고 오름차순 정렬
'''
1번 노드가 2,3노드와 연결되어 있으면
graph = [[],
[2,3],
[1],
[1],
...
]

'''
for i in range(m) :
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph :
    i.sort()

#dfs 방식 구현 함수
def dfs(v) :
    # 방문하면 해당 지점의 visited 배열을 1로 만들고 방문한점 출력
    visitedDfs[v] = 1
    print(v,end=" ")

    # v 정점과 연결된 점에서 아직 방문 안한 정점에 대해 dfs함수 재귀 실행
    for i in graph[v] :
        if visitedDfs[i] == 0 :
            dfs(i)

#bfs 구현 함수
def bfs(v) :
    queue = deque()
    # 첫 정점을 deque에 추가하고 visited 배열을 1로 변경
    queue.append(v)
    visitedBfs[v] = 1
    print(v,end = " ")

    # 방문해야할 정점이 남아있는 경우 반복문 진행
    while (queue) :
        # deque의 첫번쨰 정점을 골라 그 정점과 연결된 정점중 아직 방문하지 않은 정점을 차례대로 반복하며 visited배열을 1로 만들고 출력
        # 그 이후 새롭게 방문한 정점을 deque에 추가하며 while문 진행
        q = queue.popleft()
        for i in graph[q] :
            if visitedBfs[i] == 0 :
                visitedBfs[i] = 1
                print(i, end=" ")
                queue.append(i)


dfs(v)
print()
bfs(v)