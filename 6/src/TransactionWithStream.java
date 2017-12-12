

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TransactionWithStream {

	private static List<TransactionWithStream> allTransactions = new ArrayList<TransactionWithStream>();

	public enum TransactionType {GROCERY, PAPER, COSMETICS};

	Integer id;
	Integer value = 0;
	TransactionType type = TransactionType.GROCERY;


	public TransactionWithStream(Integer id, Integer value, TransactionType t ){
		this.id = id;
		this.value = value;
		this.type = t;
		allTransactions.add(this);
	}

	public Integer getId () { return id; }
	public Integer getValue () { return value;}
	public TransactionType getType () { return type; }


	public static void main (String[] args) {

		new TransactionWithStream(1,124,TransactionType.GROCERY);
		new TransactionWithStream(2,135,TransactionType.PAPER);
		new TransactionWithStream(3,35,TransactionType.COSMETICS);
		new TransactionWithStream(4,467,TransactionType.GROCERY);
		new TransactionWithStream(5,344,TransactionType.GROCERY);
		new TransactionWithStream(6,986,TransactionType.GROCERY);


		// *******************************************
		// Here does the code start that you should replace by
		// a stream-based formulation

		//How this would look like,
		//when done with streams?
		//Write a corresponding
		//implementation using
		//streams using filter, sorted, collect

		ArrayList<TransactionWithStream> groceryTransactions = new ArrayList<TransactionWithStream>();
		for(TransactionWithStream t: allTransactions){
			if(t.getType() == TransactionType.GROCERY){
				groceryTransactions.add(t);
			}
		}

		Collections.sort(groceryTransactions, new Comparator<TransactionWithStream>(){
			@Override
			public int compare(TransactionWithStream t1, TransactionWithStream t2) {
				return t2.getValue().compareTo(t1.getValue());
			}
		});
		
		List<Integer> transactionIds = new ArrayList<>();
		for(TransactionWithStream t: groceryTransactions){
			transactionIds.add(t.getId());
		}

		// let's see what's in there
		for (Integer i : transactionIds){
			System.out.println(i);
		}

		System.out.println("and now your stream solution: ");

		// *************************************************
		// add your stream-based solution here:

	
		List<Integer> lst = 
				allTransactions.stream()
				.filter(s -> s.getType() == TransactionType.GROCERY)
				.sorted(Comparator.comparing(s -> ((TransactionWithStream) s).getValue()).reversed())
				.map(TransactionWithStream::getId)
				.collect(Collectors.toList());

		// let's see what's in there
		
		lst.stream().forEach(System.out::println);
	}




}
