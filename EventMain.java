package data;

import java.util.ArrayList;

public class EventMain {
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	ArrayList<Integer> list_x;
	int res_arr[][];
	
//	public void print() {
//		System.out.println(list.size());
//		//System.out.println(list_x.size());
//		
//		for(int i = 0; i < list.get(0).size(); i++) {
//			for(int j = 0; j < list.size(); j++) {
//				System.out.print(list.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
//	}
	
	public void conv_arr() {
		res_arr = new int[list.size()][list.size()];
		for(int i = 0; i < list.get(0).size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				res_arr[i][j] = list.get(i).get(j);
			}
		}
		
	}
	
	public void add(String name, int idx, int distance) {
		list_x.add(distance);	
		System.out.println(list_x);
		list.get(idx).add(distance);
		//System.out.println(list_x.size());
		//System.out.println(list.get(idx).size());
		System.out.println();
		
		if(list.get(0).size() == idx + 2) {
			list_x.add(0);
			list.add(list_x);                                                                                                          
		}
		System.out.println(list_x);
	}                                                  
	
	
	
	public static void main(String[] args) {
		EventMain e = new EventMain();
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		e.list_x = new ArrayList<>();
		arr1.add(3);
		arr1.add(2);
		arr2.add(5);
		arr2.add(6);
		e.list.add(arr1);
		e.list.add(arr2);
	
		//2 x 2
		//3번째거 추가하는거
		// 0 , 1,  2 
		e.add("이름", 0, 2);
		e.add("이름", 1, 3);
		e.add("이름", 2, 4);
//		e.print();
		e.conv_arr();
		for(int i = 0 ; i <e.res_arr.length; i++) {
			for(int j = 0; j < e.res_arr[i].length; j++) {
				System.out.print(e.res_arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
	}
	
}
