package com.nickperov.stud.java_samples.j8_new;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class LambdaComparator {
	
	public static void main(String[] args) {
		makeLambdaComparatorTest001();
		//makeLambdaComparatorTest002();
	}
	
	private static void makeLambdaComparatorTest001() {
		LambdaComparator lc = new LambdaComparator();
		
		List<MarketPrice> mpTestList = lc.createTestArray(20);
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Test 1 <<<<<<<<<<<<<<<<<<<<");
		lc.sortTestArray(mpTestList, Comparator.comparingLong((MarketPrice mp) -> mp.id));
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Test 2 <<<<<<<<<<<<<<<<<<<<");
		lc.sortTestArray(mpTestList, Comparator.comparingLong((MarketPrice mp) -> mp.tradeDate != null ? mp.tradeDate.getTime() : 0L).thenComparing(mp -> mp.id).reversed());
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Test 3 <<<<<<<<<<<<<<<<<<<<");
		lc.sortTestArray(mpTestList, new Comparator<MarketPrice>() {
			@Override
			public int compare(MarketPrice o1, MarketPrice o2) {
				int res;
				if (o1.tradeDate==null || o2.tradeDate==null || (res=o2.tradeDate.compareTo(o1.tradeDate))==0)
					return Long.compare(o2.id, o1.id);  
				return res;
			}
		});
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Test 4 <<<<<<<<<<<<<<<<<<<<");
		// Date ASC compare
		Comparator<MarketPrice> dateComp = Comparator.comparingLong((MarketPrice mp) -> mp.tradeDate != null ? mp.tradeDate.getTime() : 0L);
		Comparator<MarketPrice> idComp = Comparator.comparingLong((MarketPrice mp) -> mp.id).reversed();
		lc.sortTestArray(mpTestList, dateComp.thenComparing(idComp));
		
	}
	
	private static void makeLambdaComparatorTest002() {
		
		/**
		 * Example on non transitive comparator
		 */
		
		LambdaComparator lc = new LambdaComparator();
		
		List<MarketPrice> mpTestList = lc.createTestArray(20);
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> Test <<<<<<<<<<<<<<<<<<<<");
		List<MarketPrice> prevSort = null;
		int i = 0;
		while (i++ < 10) {
			List<MarketPrice> list = new ArrayList<>(mpTestList);
			Collections.shuffle(list);
			lc.sortTestArray(list, new Comparator<MarketPrice>() {
				@Override
				public int compare(MarketPrice o1, MarketPrice o2) {
					int res;
					if (o1.tradeDate==null || o2.tradeDate==null || (res=o2.tradeDate.compareTo(o1.tradeDate))==0)
						return Long.compare(o2.id, o1.id);  
					return res;
				}
			});
			
			if (prevSort != null && !list.equals(prevSort)) {
				System.out.println("!!! Sort problem");
				break;
			}
			
			prevSort = list;
		}
	}
	
	private void sortTestArray(List<MarketPrice> mpList, Comparator<MarketPrice> comp) {
		System.out.println("======================= Before sort =====================");
		mpList.forEach(mp -> System.out.println(mp.toString()));
		System.out.println("======================= After sort =====================");
		mpList.sort(comp);
		mpList.forEach(mp -> System.out.println(mp.toString()));
		
		// Reduce sort check
		System.out.println("Sort check: "  + mpList.stream().map(mp -> mp.id).reduce((n1, n2) -> n1 < n2 ? n2 : 10000L).orElse(1000L));
		//System.out.println("Sort check: " +mpList.stream().filter(mp -> mp.tradeDate != null).reduce((mp1, mp2) -> (mp1 != null && mp2 != null && mp1.tradeDate.after(mp2.tradeDate)) ? null : mp2).filter(mpf -> mpf != null).isPresent());
		
	}
	
	private List<MarketPrice> createTestArray(int volume) {
		
		List<MarketPrice> mpList = new ArrayList<>(volume);
		int i = 0;
		while (i++ < volume) {
			Date tradeDate = i == 3 || i == 7 ? null : new Date((long)(new Random().nextDouble()*10000000000000L));
			BigDecimal value = new BigDecimal(new Random().nextDouble());
			
			mpList.add(new MarketPrice(Long.valueOf(i), tradeDate, value));
		}
		
		return mpList;
	}
	
	class MarketPrice {
		private MarketPrice(Long id, Date tradeDate, BigDecimal value) {
			this.id = id;
			this.tradeDate = tradeDate;
			this.value = value;
		}
		
		Long id;
		Date tradeDate;
		BigDecimal value;
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			return sb.append("id: ").append(id).append(", tradeDate: ").append(tradeDate == null ? "   NULL  " : new SimpleDateFormat("dd/MM/yyyy").format(tradeDate)).append(", value: ").append(value).toString();
		}
	}
}
