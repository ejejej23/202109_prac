package kakao;

import java.util.ArrayList;
import java.util.HashMap;

class MsgUser{
	String action;
	String id;

	MsgUser(String action, String id){
		this.action = action;
		this.id = id;
	}
}

public class Kakao_19_1 {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}

	public static String[] solution(String[] record) {
		ArrayList<MsgUser> users = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();

		for(String str: record){
			String[] arr = str.split(" ");

			switch (arr[0]){
				case "Enter":
					map.put(arr[1],arr[2]);
					users.add(new MsgUser(arr[0], arr[1]));
					break;
				case "Leave":
					users.add(new MsgUser(arr[0], arr[1]));
					break;
				case "Change":
					map.put(arr[1],arr[2]);
					break;
			}
		}

		int size = users.size();
		String[] answer = new String[size];
		for(int i=0; i< size; i++){
			MsgUser msg = users.get(i);
			switch (msg.action){
				case "Enter":
					answer[i] = map.get(msg.id)+"님이 들어왔습니다.";
					break;
				case "Leave":
					answer[i] = map.get(msg.id)+"님이 나갔습니다.";
					break;
			}
		}


        return answer;
    }
}
