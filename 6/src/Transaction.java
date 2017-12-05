

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Transaction {

	private static List<Transaction> allTransactions = new ArrayList<Transaction>();

	public enum TransactionType {GROCERY, PAPER, COSMETICS};

	Integer id;
	Integer value = 0;
	TransactionType type = TransactionType.GROCERY;


    public Transaction(Integer id, Integer value, TransactionType t ){
    	this.id = id;
		this.value = value;
		this.type = t;
		allTransactions.add(this);
    }

    public Integer getId () { return id; }
	public Integer getValue () { return value;}
	public TransactionType getType () { return type; }


	public static void main (String[] args) {

		new Transaction(1,124,TransactionType.GROCERY);
		new Transaction(2,135,TransactionType.PAPER);
		new Transaction(3,35,TransactionType.COSMETICS);
		new Transaction(4,467,TransactionType.GROCERY);
		new Transaction(5,344,TransactionType.GROCERY);
		new Transaction(6,986,TransactionType.GROCERY);


		ArrayList<Transaction> groceryTransactions = new ArrayList<Transaction>();
		for(Transaction t: allTransactions){
			if(t.getType() == TransactionType.GROCERY){
					groceryTransactions.add(t);
				}
			}
			Collections.sort(groceryTransactions, new Comparator<Transaction>(){
				@Override
				public int compare(Transaction t1, Transaction t2) {
					return t2.getValue().compareTo(t1.getValue());
					}
				});
			List<Integer> transactionIds = new ArrayList<>();
			for(Transaction t: groceryTransactions){
				transactionIds.add(t.getId());
			}

			// let's see what's in there
			for (Integer i : transactionIds){
				System.out.println(i);
			}

			System.out.println("and now your stream solution: ");


	

			// ....  place your code ....



			// let's see what's in there
			for (Integer i : transactionIds){
				System.out.println(i);
		}
	}




}
