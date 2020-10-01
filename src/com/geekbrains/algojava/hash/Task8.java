package com.geekbrains.algojava.hash;

public class Task8 extends BaseClass {
    /*
     * Задание 8.1
     * Приведите пример использование хеш-таблиц
     * используются для осуществления константного времни выполнения операций вставки/удаления.
     * Пример: использутюся в механизме авторизации пользователей для сокрытия истинного значения пароля в БД
     *
     * Задание 8.2
     * Приведите примеры ключей и коллизий.
     * Ключ - входные данные в хеш-функцию, пример - при хешировании пароля логин используется как ключ для хеш-функции
     * Коллизия - ситуация, когда для больше одного ключа возвращается одно и тоже значении хеш-функции,
     * пример - имеем Ключ2 и Ключ3, для которых соответственно возвращается Хеш-значение для Ключ2
     *
     * Задание 8.3
     * Приведите примеры популярных и эффективных хеш-функций.
     * CRC16/32, MD5, SHA
     */

    public static void linearProbing() {
        System.out.println("\nЗадание 8.4\n" +
                "         * На основе данных массива из задания 2.3 реализуйте хеш-таблицу с\n" +
                "         * помощью открытой адресации, а конкретнее метода линейного пробирования");
        Task2 task2 = new Task2();
        int[] arr = task2.getArray400();
        HashTable hashTable = new HashTable(arr.length + 50);
        for (int i : arr) {
            hashTable.insert(new Item(i));
        }
        hashTable.display();
    }

    public static void doubleHash() {
        System.out.println("\nЗадание 8.5\n" +
                "        * Перестройте программный код задания 8.4 из алгоритма линейного\n" +
                "        * пробирования в алгоритм двойного хеширования.");
        Task2 task2 = new Task2();
        int[] arr = task2.getArrayOfRandomIntegers(210);
        HashTableD hashTableD = new HashTableD(arr.length + 50);
        for (int i : arr) {
            hashTableD.insert(new Item(i));
        }
        hashTableD.display();
        if (hashTableD.find(1) != null) {
            hashTableD.delete(1);
            hashTableD.display();
        }
    }

    public static void main(String[] args) {
        linearProbing();
        doubleHash();
        /*
         * Сравните отличительные черты двух алгоритмов.
         * Главное отличие между линейным проированием и двойным хешированием - двойное хеширование имеет
         * вспомогательную хеш функцию для вычисления интеврала между ячейками хеш таблицы
         */
    }


}