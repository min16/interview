# 자료구조
* #### Tree
  * #### Binary Search tree
  * #### Self-Balancing BSTs
    * #### AVL Tree
    * #### Red Black Tree
    * #### Splay Tree
    * #### B Tree
* #### Priority Queue
* #### Binary Heap
* #### Hashing
----
## Binary Search Tree
`선형 자료구조`인 Arrays, Linked Lists, Stack, Queues와  다르게 tree는 `계층 자료구조`이다. `binary tree`는 자식 노드가 최대 2개를 뜻한다. `binary search tree`는 아래와 같은 특성을 가진다.

* 왼쪽 서브트리의 모든 노드들은 현재 노드보다 값이 작다
* 오른쪽 서브트리의 모든 노드들은 현재 노드보다 값이 크다
* 왼쪽과 오른쪽 서브트리 모두 `binary search tree`이다

연산에서 best case는 `O(log n)`, worst case는 `O(n)`이다.

#### Procedure

<<<<<<< HEAD
#### Advantages of BST over Hash Table

#### How to solve duplicate key

=======
#### How to handle duplicates in BST?

---
## Self-Balancing BSTs
BST는 삽입 삭제시 `O(h)` 걸린다. skewed binary tree는 `O(n)`. self-balancing BST는 항상 `O(h)`를 보장한다. 높이를 줄여 균형된 트리를 만든다.
각 트리마다 다른 특징이 있다.

* AVL Tree
* Red Black Tree
* Splay Tree
* B Tree
---

## AVL Tree
AVL tree는 __왼쪽 서브트리의 높이와 오른쪽 서브트리의 높이의 차로__ balnace를 확인한다. 그러므로 node에 height field가 있다.

#### Balnace Factor (BF)
`왼쪽 서브트리 높이 - 오른쪽 서브트리 높이`. BF 값을 __-1이상, 1이하를 유지__ 해야한다. 즉, 양쪽 높이 차이가 2이상 차이나면 안된다. 범위를 벗어나면 `rotation`으로 rebalancing 한다.

#### Procedure
* `insert()`: standard BST insert 후, `bottom-up` 방식으로 진행하여 node의 height를 update하고 `unbalanced node`를 찾아 rotate한다.
* `delete()`: standard BST delete 후, insert()와 동일하다. 단, 더 큰 높이 값을 가진 노드들로 rotate 된다.
* `rotate()`: 4가지 case로 `left-left, left-right, right-right, right-left`가 있다.
>>>>>>> 5b0aae066046365e5fb72fbfec0fb06b3d43cb09
---

## Red Black Tree
self-balancing tree, node에 color field가 추가된다.
red black tree는 삽입, 삭제시 `O(log n)`을 보장한다. 상수 시간을 갖는 `recoloring`과 `rotation`으로 balancing 한다.

#### Property
1. 모든 node는 black 또는 red를 가진다.
2. Root는 항상 black 이다.
3. node가 red이면 부모는 항상 black 이다.
4. node x로부터 leaf까지 black 갯수는 항상 같다. black-height(x)
5. leaf node는 항상 black이다.

#### Comparison with AVL tree
<<<<<<< HEAD
모두 balanced search tree이다. AVL tree는 삽입 삭제시 rotation이 더 잦다. 그러므로 삽입 삭제가 적고 __검색이 많을때__ 선호된다.
=======
AVL tree는 less depth이므로 검색이 빠르다. 대신 삽입 삭제시 rotation이 더 잦다. 그러므로 삽입 삭제가 적고 __검색이 많을때 선호__ 된다.
>>>>>>> 5b0aae066046365e5fb72fbfec0fb06b3d43cb09

#### Height of Red Black tree
n개를 가지는 red black tree의 높이는 최대 2log(n+1)이다.
>bh >= h / 2

> n = 2 ^ bh - 1

<<<<<<< HEAD
#### Insert Operation
1. recoloring
=======
---
>>>>>>> 5b0aae066046365e5fb72fbfec0fb06b3d43cb09

## Splay Tree
최근에 사용된 key를 root로 옮겨 (splay) reblanacing하는 tree. 이전에 검색한 node에 대해 `O(1)`로 수행한다. 그러므로 수많은 key들 중 몇개만 자주 사용될 때 유용하다. 평균 연산 시간은 `O(log n)`.

<<<<<<< HEAD
2. rotation

  parent는 red지만 uncle이 black인 경우이다. left-rotate 또는 right-rotate를 한다. rotate 연산은 O(1)이다.
---
## AVL Tree
=======
#### Procedure
* `splay()`: rotate통해 node를 root로 옮긴다.
* `search(), insert()`: standard BST 연산 이후 `splay()` 한다.
* `delete()`: `splay()`하여 root 삭제 후 왼쪽과 오른쪽 서브트리를 분리한다. 왼쪽 서브트리의 max값을 `splay()` 후 오른쪽 서브트리와 합친다.  

#### Property
* Frequently accessed items는 싼 비용으로 찾을 수 있다.
* AVL tree, Red Black tree보다 단순하고 extra field가 없다.
* `search()`로 node 위치가 변경된다.
---

## B Tree
다른 self-balnacing search tree와 다르게 main memory에 들어가지 않는 매우 큰 data를 저장할때 사용한다. (database, file system) minimum dgree 또는 maximum degree가 있어서 하나의 node에 여러개 key를 가지고 있다.
>>>>>>> 5b0aae066046365e5fb72fbfec0fb06b3d43cb09

#### Hash Indexes vs B Tree Indexes
Hash indexes는 `equality` 쿼리에 적합히다. B tree indexes는 범위 기반 검색에 적합하다. (ex, 나이가 20 이상, a로 시작하는 이름) 또한 유지 및 스케일링이 쉽다는 장점이 있다.
---


## Priority Queue
FIFO queue와는 다르게 `우선순위가 높은 순서대로` 나온다. `key`로 순위를 정한다. 우선순위가 가장 높은 요소가 맨 앞에 있고, 그 요소가 삭제되면 다음으로 높은 요소가 맨 앞으로 간다. `Heap`으로 구현한다. 우선순위가 가장 높은 N개를 구할때 적합하다.

#### Procedure
 * `getMaximum()`:
 * `insert()`:
 * `deleteMaximum()`:

#### Applications
* Dijkstras' Shortest Path Algorithm using priority queue
* Prim's algorithm
* Data compression
* Heap Sort
* Operating System

#### Questions
* java priority queue는 array로 구현되어있는가? insert는 어떻게 하는거지?
* 언제 사용? 가장 큰 값 N개
* fibonacci heap으로 구현하기
* Applications
---

## Binary Heap
`binary heap`은 `array`이며 `complete binary tree`로 나타낸다. `binary tree`에 __순서__ 가 추가 된 자료구조이다.
 * `max heap`: 부모 노드 값이 자식 노드 값보다 __크거나 같은__ `complete binary tree`. `rooot`에 가장 **큰 값** 이 저장 된다.
 * `min heap`: 부모 노드 값이 자식 노드 값보다 __작거나 같은__ `complete binary tree`. `root`에 가장 **작은 값** 이 저장 된다.

#### Procedure
* `MAX-HEAPIFY`: `siftDown`방법으로 max-heap property 유지, `O(log n)`
* `BUILD-MAX-HEAP`: unordered input `array`를 max-heap으로 변경, `O(n)`
* `HEAPSORT`: `binary heap`을 이용한 정렬, `O(nlog n)`
* `MAX-HEAP-INSERT, HEAP-EXTRACT-MAX, HEAP-INCREAS-KEY, HEAP-MAXIMUM`: `priority queue`에 사용, `O(long n)`

#### Applications
* Dijkstras' Shortest Path Algorithm using priority queue
* Prim's algorithm
* Heap Sort
---

## Hash Table
---
