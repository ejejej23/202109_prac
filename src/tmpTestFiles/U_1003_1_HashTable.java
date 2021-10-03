package tmpTestFiles;

import com.sun.jdi.connect.spi.TransportService;

import java.util.LinkedList;

class HashTable{
    class Node {
        String key;
        String value;

        public Node (String key, String value){
            this.key = key;
            this.value = value;
        }

        String getValue(){
            return value;
        }

        void setValue(String value){
            this.value = value;
        }

    }
    LinkedList<Node>[] data;

    HashTable(int size){
        this.data = new LinkedList[size];
    }

    int getHashCode(String key){
        int hashcode = 0;
        //value의 아스키코드 값을 더하도록 처리
        for(char c: key.toCharArray()){
            hashcode += c;
        }
        return hashcode;
    }

    int convertToIndex(int hashcode){
        //hashcode를 배열의 크기로 나눈 나머지를 인덱스로 사용
        return hashcode % data.length;
    }

    Node searchKey(LinkedList<Node> list, String key){
        if(list == null) return null;
        for(Node node : list){
            if(node.key.equals(key)){
                return node;
            }
        }
        return null;
    }

    void put(String key, String value){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];//이값은 무조건 존재함
        if(list == null){
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if(node == null){
            list.addLast(new Node(key,value));
        }else{
            node.setValue(value);//중복값이 나오는 경우 덮어쓰기로 진행
        }
    }

    String get(String key){
        int hashcode = getHashCode(key);
        int index = convertToIndex(hashcode);
        LinkedList<Node> list = data[index];
        Node node = searchKey(list,key);
        return node == null? "not found": node.getValue();
    }
}

public class U_1003_1_HashTable {
    public static void main (String[] args){
        HashTable h = new HashTable(3);
        h.put("A","apple");
        h.put("B","banana");
        h.put("C","cyber");
        h.put("A","abba");

        System.out.println(h.get("A"));
        System.out.println(h.get("D"));
    }
}
