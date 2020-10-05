package com.geekbrains.algojava.home6;



public class Tree extends BaseClass {

    private Node root;

    public void insert(Person person) {
        startTime = System.nanoTime();
        Node node = new Node(person);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (person.getId() < current.getPerson().getId()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(node);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(node);
                        return;
                    }
                }
            }
        }
        endTime = System.nanoTime();
        printTimeExecution("Tree:insert ", startTime, endTime);
    }

    public Node find(int key) {
        startTime = System.nanoTime();
        Node current = root;
        while (current.getPerson().getId() != key) {
            current = key < current.getPerson().getId()
                    ? current.getLeftChild()
                    : current.getRightChild();
            if (current == null) return null;
        }
        endTime = System.nanoTime();
        printTimeExecution("Tree:find ", startTime, endTime);
        return current;
    }

    //обход дерева: вывод узлов
    public void inOrder(Node parentNode) {
        if (parentNode != null) {
            inOrder(parentNode.getLeftChild());
            parentNode.display();
            inOrder(parentNode.getRightChild());
        }
    }

    public void preOrder(Node parentNode) {
        if (parentNode != null) {
            parentNode.display();
            preOrder(parentNode.getLeftChild());
            preOrder(parentNode.getRightChild());
        }
    }

    public void postOrder(Node parentNode) {
        if (parentNode != null) {
            postOrder(parentNode.getLeftChild());
            postOrder(parentNode.getRightChild());
            parentNode.display();
        }
    }

    //поиск самого нижнего левого элемента
    public Node min() {
        startTime = System.nanoTime();
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        endTime = System.nanoTime();
        printTimeExecution("Tree:min ", startTime, endTime);
        return last;
    }

    public Node max() {
        startTime = System.nanoTime();
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        printTimeExecution("Tree:max ", startTime, endTime);
        return last;
    }

    public Boolean delete(int key) {
        startTime = System.nanoTime();
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        //ищем узел
        while (current.getPerson().getId() != key) {
            parent = current;
            if (key < parent.getPerson().getId()) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) {
                endTime = System.nanoTime();
                printTimeExecution("Tree:delete ", startTime, endTime);
                return false;
            }
        }
        //удаляем узел
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeftChild(successor);
            } else {
                parent.setRightChild(successor);
            }
        }
        endTime = System.nanoTime();
        printTimeExecution("Tree:delete ", startTime, endTime);
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getRightChild();
        }

        if (successor != node.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(node.getRightChild());
        }
        return successor;
    }

    public void displayTree() {
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(root);
    }

}

class Node {
    private Person person;
    private Node leftChild;
    private Node rightChild;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void display() {
        System.out.println("Имя: " + person.getName() + ", id: " + person.getId());
    }
}

class Person {
    private final int id;
    private final String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}