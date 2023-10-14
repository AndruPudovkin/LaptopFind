import java.util.*;


public class Main {
    /*
     Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
     Создать множество ноутбуков.
     Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру.
     Критерии фильтрации можно хранить в Map.
     Например:
     “Введите цифру, соответствующую необходимому критерию:
     1 - ОЗУ
     2 - Объем ЖД
     3 - Операционная система
     4 - Цвет …
     Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
     Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
     Работу сдать как обычно ссылкой на гит репозиторий
     Частые ошибки:
     1. Заставляете пользователя вводить все существующие критерии фильтрации
     2. Невозможно использовать более одного критерия фильтрации одновременно
     3. При выборке выводятся ноутбуки, которые удовлетворяют только одному фильтру, а не всем введенным пользователем
     4. Работа выполнена только для каких то конкретных ноутбуков, и если поменять характеристики ноутбуков или добавить еще ноутбук,
         то программа начинает работать некорректно
     */
    public static void main(String[] args) {
        HashSet<Laptop> laptopSet = new HashSet<>();
        setRandomLaptop(laptopSet);
        HashMap<Integer, List> findLaptopHash = definingSearchParameters();
        Laptop laptop = new Laptop();
        HashSet<Laptop> resFindLaptop = laptop.findLaptop(laptopSet, findLaptopHash);
        printSet(resFindLaptop);

    }

    static void setRandomLaptop(Set<Laptop> laptopSet) {
        Random random = new Random();
        HashMap<Integer, Integer> arrRam = new HashMap<>();
        arrRam.put(1, 1);
        arrRam.put(2, 4);
        arrRam.put(3, 8);
        arrRam.put(4, 16);
        HashMap<Integer, Integer>  arrMemoryCapasity = new HashMap<>();
        arrMemoryCapasity.put(1, 126);
        arrMemoryCapasity.put(2, 252);
        arrMemoryCapasity.put(3, 500);
        arrMemoryCapasity.put(4, 1000);
        HashMap<Integer, String> arrOs = new HashMap<>();
        arrOs.put(1, "MacOS");
        arrOs.put(2, "Linux");
        arrOs.put(3, "Windows 11");
        HashMap<Integer, String> arrColour = new HashMap<>();
        arrColour.put(1, "Red");
        arrColour.put(2, "Yellow");
        arrColour.put(3, "Black");
        arrColour.put(4, "Gray");
        arrColour.put(5, "White");
        arrColour.put(6, "Blue");
        int i = 0;
        while (i <= 10) {
            Laptop laptop = new Laptop();
            laptop.setRam(arrRam.get(random.nextInt(1, 5)));
            laptop.setMemoryСapacity(arrMemoryCapasity.get(random.nextInt(1, 5)));
            laptop.setOs(arrOs.get(random.nextInt(1, 4)));
            laptop.setColour(arrColour.get(random.nextInt(1, 7)));
            laptopSet.add(laptop);
            i++;
        }
        int k = 1;
        for (Laptop item : laptopSet) {
            System.out.println("Laptop " + k + ": ОЗУ - " + item.getRam() + " Объем ЖД - " + item.getMemoryСapacity() + " Операционная система - " + item.getOs() + " Цвет - " + item.getColour());
            k++;

        }
    }


    static HashMap<Integer, List> definingSearchParameters() {
        Scanner scanner = new Scanner(System.in);
        boolean work = true;
        List<Integer> listRam = new ArrayList<>();
        List<Integer> listMemoryСapacity = new ArrayList<>();
        List<String> listOs = new ArrayList<>();
        List<String> listColour = new ArrayList<>();
        while (work) {
            System.out.println("Введите цифру, соответствующую необходимому критерию \n" +
                    "1 - ОЗУ\n" +
                    "2 - Объем ЖД\n" +
                    "3 - Операционная система\n" +
                    "4 - Цвет\n" +
                    "5 - Начать поиск");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    int ram;
                    System.out.println("Введите значение ОЗУ один из предложенных вариантов: 1, 4, 8, 16");
                    ram = scanner.nextInt();
                    if (ram == 1 || ram == 4 || ram == 8 || ram == 16) {
                        listRam.add(ram);
                    } else {
                        System.out.println("Вы ввели что то не то. Попробуй еще раз!");
                    }
                    break;
                case 2:
                    int memoryСapacity;
                    System.out.println("Введите значение объема ЖД из предложенных вариантов: 126, 252, 500, 1000");
                    memoryСapacity = scanner.nextInt();
                    if (memoryСapacity == 126 || memoryСapacity == 252 || memoryСapacity == 500 || memoryСapacity == 1000) {
                        listMemoryСapacity.add(memoryСapacity);
                    } else {
                        System.out.println("Вы ввели что то не то. Попробуй еще раз!");
                    }
                    break;
                case 3:
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Введите название одно из названий ОС: MacOS, Linux, Windows 11");
                    String nameOS = scanner1.nextLine();
                    if (nameOS.equals("MacOS") || nameOS.equals("Linux") || nameOS.equals("Windows 11")) {
                        listOs.add(nameOS);
                    } else {
                        System.out.println("Вы ввели что то не то. Попробуй еще раз!");
                    }
                    break;
                case 4:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Введите одно из название цвета: Red, Yellow, Black, Gray, White, Blue");
                    String name = scanner2.nextLine();
                    if (name.equals("Red") || name.equals("Yellow") || name.equals("Black") || name.equals("Gray") || name.equals("White") || name.equals("Blue")) { //условие слишком длинное можно было с помощью массива и цикла  for  сделать, но не стал усложнять, не думаю что это сильно критично для текущей задачи
                        listColour.add(name);
                    } else {
                        System.out.println("Вы ввели что то не то. Попробуй еще раз!");
                    }
                    break;
                case 5:
                    work = false;
            }
        }
        HashMap<Integer, List> resHash = new HashMap<>();
        resHash.put(1, listRam);
        resHash.put(2, listMemoryСapacity);
        resHash.put(3, listOs);
        resHash.put(4, listColour);
        return resHash;
    }

    static void printSet (HashSet<Laptop> set){
        int i = 0;
        for (Laptop item : set) {
            System.out.println("Laptop " + i + ": ОЗУ - " + item.getRam() + " Объем ЖД - " + item.getMemoryСapacity() + " Операционная система - " + item.getOs() + " Цвет - " + item.getColour());
            i++;

        }
    }


}