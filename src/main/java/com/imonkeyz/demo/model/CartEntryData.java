package com.imonkeyz.demo.model;

/**
 * Created by Jesse.Zhou on 2017/2/21 0021.
 */
public class CartEntryData {
    private long entryNumber;
    private long quantity;

    /**
     *
     */
    public CartEntryData()
    {
        // YTODO Auto-generated constructor stub
    }

    /**
     * @return the entryNumber
     */
    public long getEntryNumber()
    {
        return entryNumber;
    }

    /**
     * @param entryNumber the entryNumber to set
     */
    public void setEntryNumber(long entryNumber)
    {
        this.entryNumber = entryNumber;
    }

    /**
     * @return the quantity
     */
    public long getQuantity()
    {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(long quantity)
    {
        this.quantity = quantity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "CartEntryData [entryNumber=" + entryNumber + ", quantity=" + quantity + "]";
    }
}
