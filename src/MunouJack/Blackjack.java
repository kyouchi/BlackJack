package MunouJack;

import java.io.IOException;
import java.util.Random;


public class Blackjack{
    	final int card1=RandomCard();
    	final int card2=RandomCard();
    	final int card3=RandomCard();
    	final int card4=RandomCard();
    	final int card5=RandomCard();
    	boolean Bust_judge;
    	static public boolean AceCounter=false;

		Blackjack(){
			Bust_judge=false;
		}

    	private int RandomCard(){
    		Random rnd = new Random();
    		int result=rnd.nextInt(13)+1;
    		if(result==11||result==12||result==13){
    			result=10;//13の時もスコア10にする。(問題文未記載)
    		}
    		else{
    			if(result==1){
        			AceCounter=true;
        		}
    		}
    		return result;
    	}

    	int getScore(int turn){
    		int Total=0;
    		switch(turn){
    		case 1:
    			Total=card1+card2;
    			break;
    		case 2:
    			Total=card1+card2+card3;
    			break;
    		case 3:
    			Total=card1+card2+card3+card4;
    			break;
    		case 4:
    			Total=card1+card2+card3+card4+card5;
    			break;
    		}
    		if(Total<=11){//1->11に変換するかどうか判定
    			if(AceCounter){
    				return Total+=10;
    			}
    			else{
    	    		return Total;
    			}
    		}
    		if(!(Total<=21)){
				Bust_judge=true;
				return Total;//Bust

    		}
    		return Total;
    	}


       static  boolean Blackjack_judge(int i){
        	if(i==21){
        		return true;
        	}
        	else{
        		return false;
        	}
        }

       static int Key_judge(){
    	   int key;
           try{
        	   key = System.in.read();
           }
	       catch(IOException e){
	           System.err.println( "入力エラーです。" );
	           key = -1;
	       }
           return key;
       }


    public static void main(String[] args) {

        Blackjack foo = new Blackjack();
        for(int turn=1;turn<=4;turn++){
        	int key=0;
	        System.out.println("Turn"+turn);
           	System.out.println();
	        System.out.println("スコア: "+foo.getScore(turn));
	        System.out.println("1枚目のカード: "+foo.card1);
	        System.out.println("2枚目のカード: "+foo.card2);
	        if(turn==1){
	        	if(Blackjack_judge(foo.getScore(turn))){
		        	System.out.println("BlackJack(ペイアウト)です。");
		        	break;
	        	}
	        	if(foo.Bust_judge){
		        	System.out.println("あなたの負けです。");
		        	break;
	        	}
	        	System.out.println("続行しますか?(yなら続行)");
		        key = Key_judge();
		        if((char)key=='y'){
			    	System.out.println("-------------------------------------------");
		          	continue;
		        }
		        else{
		          	System.out.println("ここで止めました。");
		           	System.out.println();
		           	System.out.println("3枚目のカードは"+foo.card3+"でした。");
		           	System.out.println("4枚目のカードは"+foo.card4+"でした。");
		           	System.out.println("5枚目のカードは"+foo.card5+"でした。");
		           	break;
		        }
	        }
	        if(turn==2){
	        	System.out.println("3枚目のカード: "+foo.card3);
	        	if(Blackjack_judge(foo.getScore(turn))){
		        	System.out.println("BlackJackです。");
		        	break;
	        	}
	        	if(foo.Bust_judge){
		        	System.out.println("あなたの負けです。");
		        	break;
	        	}
	        	System.out.println("続行しますか?(yなら続行)");
		        key = Key_judge();
		        if((char)key=='y'){
			        System.out.println("-------------------------------------------");
		           	continue;
		        }else{
		           	System.out.println("ここで止めました。");
		           	System.out.println();
		           	System.out.println("4枚目のカードは"+foo.card4+"でした。");
		           	System.out.println("5枚目のカードは"+foo.card5+"でした。");
		           	break;
		        }
	        }
	        if(turn==3){
	        	System.out.println("3枚目のカード: "+foo.card3);
	        	System.out.println("4枚目のカード: "+foo.card4);
	        	if(Blackjack_judge(foo.getScore(turn))){
		        	System.out.println("BlackJackです。");
		        	break;
	        	}
	        	if(foo.Bust_judge){
		        	System.out.println("あなたの負けです。");
		        	break;
	        	}
	        	System.out.println("続行しますか?(yなら続行)");
		        key = Key_judge();
		        if((char)key=='y'){
			        System.out.println("-------------------------------------------");
		            continue;
		        }
		        else{
		            System.out.println("ここで止めました。");
		           	System.out.println();
		           	System.out.println("5枚目のカードは"+foo.card5+"でした。");
		           	break;
		        }
	        }
	        if(turn==4){
	        	System.out.println("3枚目のカード: "+foo.card3);
            	System.out.println("4枚目のカード: "+foo.card4);
	        	System.out.println("5枚目のカード: "+foo.card5);
	        	if(Blackjack_judge(foo.getScore(turn))){
		        	System.out.println("BlackJack+5カードです");
	        	}else{
		        	System.out.println("5カードです");
	        	}
	        }
        }
    }
}