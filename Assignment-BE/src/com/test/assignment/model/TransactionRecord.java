/**
 * 
 */
package com.test.assignment.model;

/**
 * Transaction Record Model
 */
public class TransactionRecord {

	/**
	 * Transaction Reference ID
	 */
	private Long transactionRefId;

	/**
	 * Account Number IBAN
	 */
	private String accNoIBAN;

	/**
	 * Transaction Description
	 */
	private String description;

	/**
	 * Start Balance
	 */
	private Double startBal;

	/**
	 * End Balance
	 */
	private Double endBalance;

	/**
	 * Mutation
	 */
	private Double mutation;

	/**
	 * @return the transactionRefId
	 */
	public Long getTransactionRefId() {
		return transactionRefId;
	}

	/**
	 * @param transactionRefId the transactionRefId to set
	 */
	public void setTransactionRefId(Long transactionRefId) {
		this.transactionRefId = transactionRefId;
	}

	/**
	 * @return the accNoIBAN
	 */
	public String getAccNoIBAN() {
		return accNoIBAN;
	}

	/**
	 * @param accNoIBAN the accNoIBAN to set
	 */
	public void setAccNoIBAN(String accNoIBAN) {
		this.accNoIBAN = accNoIBAN;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the startBal
	 */
	public Double getStartBal() {
		return startBal;
	}

	/**
	 * @param startBal the startBal to set
	 */
	public void setStartBal(Double startBal) {
		this.startBal = startBal;
	}

	/**
	 * @return the endBalance
	 */
	public Double getEndBalance() {
		return endBalance;
	}

	/**
	 * @param endBalance the endBalance to set
	 */
	public void setEndBalance(Double endBalance) {
		this.endBalance = endBalance;
	}

	/**
	 * @return the mutation
	 */
	public Double getMutation() {
		return mutation;
	}

	/**
	 * @param mutation the mutation to set
	 */
	public void setMutation(Double mutation) {
		this.mutation = mutation;
	}
}
