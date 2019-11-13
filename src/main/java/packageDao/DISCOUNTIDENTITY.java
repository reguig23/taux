/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDao;

/**
 *
 * @author pedago
 */
public class DISCOUNTIDENTITY {
    public String lettre;
    public float taux;
    public DISCOUNTIDENTITY(String a ,float b){
        lettre=a;
        taux=b;
       
    }
    
    public String getDiscount_code(){
        return lettre;
    }
    
    public float gettaux(){
        return taux;
        
    }
}
