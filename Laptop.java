import java.util.*;

public class Laptop {
    int ram;
    int memoryСapacity;
    String os;
    String colour;

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemoryСapacity() {
        return memoryСapacity;
    }

    public void setMemoryСapacity(int memoryСapacity) {
        this.memoryСapacity = memoryСapacity;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
//    HashSet<Laptop>
    public  HashSet<Laptop> findLaptop(HashSet<Laptop> laptopSet, HashMap<Integer, List> findLaptopHash ){
//        HashMap<Integer,List> test1 = new HashMap<>();
//        HashMap<Integer,List> test2 = new HashMap<>();
//        List<String> listTest = new ArrayList<>();
//        listTest.add("Ok");
//        test1.put(1, listTest);
        HashSet<Laptop> resFind = new HashSet<>();
        List<Integer> listRam = findLaptopHash.get(1);
        List<Integer> listMemoryСapacity = findLaptopHash.get(2);
        List<String> listOs = findLaptopHash.get(3);
        List<String> listColour = findLaptopHash.get(4);
        List<Integer> listRamSet = new ArrayList<>();
        List<Integer> listMemoryСapacitySet = new ArrayList<>();
        List<String> listOsSet = new ArrayList<>();
        List<String> listColourSet = new ArrayList<>();
        for (Laptop item: laptopSet) {
            listRamSet.add(item.getRam());
            listMemoryСapacitySet.add(item.getMemoryСapacity());
            listOsSet.add(item.getOs());
            listColourSet.add(item.getColour());
        }
        if(listRam.size()==0 && listMemoryСapacity.size()==0 && listOs.size()==0 && listColour.size()==0 ){
            return laptopSet;
        }
        for (Laptop item: laptopSet){
            int ram = item.getRam();
            int sizeRam = listRam.size();
            for (int i = 0; i < sizeRam; i++) {
                if(listRam.get(i) == ram){
                    resFind.add(item);
                }
            }
            int memoryСapacity = item.getMemoryСapacity();
            int sizeMemoryСapacity = listMemoryСapacity.size();
            for (int i = 0; i < sizeMemoryСapacity ; i++) {
                if(listMemoryСapacity.get(i) == memoryСapacity){
                    resFind.add(item);
                }
            }
            String oS = item.getOs();
            int sizeOs = listOs.size();
            for (int i = 0; i < sizeOs ; i++) {
                if(listOs.get(i).equals(oS)){
                    resFind.add(item);
                }
            }
            String colour = item.getColour();
            int sizeColour = listColour.size();
            for (int i = 0; i < sizeColour; i++) {
                if(listColour.get(i).equals(colour)){
                    resFind.add(item);
                }
            }
        }
        if (resFind.size() == 0){
            System.out.println("Таких ноутбуков нет");
            return laptopSet;
        }
        return resFind;
        }
}