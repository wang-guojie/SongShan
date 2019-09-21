package unit;

import java.util.List;

import entity.Goods;

public class AorB {
	
	public static boolean if_one(List<Goods> list, int id) {
		
		for (Goods goods : list) {
			
			if (goods.getId() == id){
				
				return true;
			} 
			
		}
		
		return false;
	}
	
}
