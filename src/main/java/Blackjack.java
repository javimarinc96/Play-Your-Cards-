public class Blackjack {

    public int parseCard(String card) {
        int res = 0;
        switch(card){
            case "ace":
                res = 11;
                break;
            case "ten": case "jack": case "queen": case "king": 
                res = 10;
                break;
            case "nine":
                res = 9;
                break;
            case "eight":
                res = 8;
                break;
            case "seven":
                res = 7;
                break;
            case "six":
                res = 6;
                break;
            case "five":
                res = 5;
                break;
            case "four":
                res = 4;
                break;
            case "three":
                res = 3;
                break;
            case "two":
                res = 2;
                break;
            default:
                res = 0;
                break;
        }
        return res;
    }

    public boolean isBlackjack(String card1, String card2) {
        int value1= parseCard(card1);
        int value2= parseCard(card2);
        if(value1 + value2 == 21){
            return true;
        }
            return false;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        if(!isBlackjack){
            return "P";
            }
        
        if(dealerScore < 10) {
            return "W";
        }

        return "S";
        }
    

    public String smallHand(int handScore, int dealerScore) {
        if(handScore >= 17){
            return "S";
        }else if(handScore <= 11){
            return "H";
        }else{
            if(dealerScore >= 7){
                return "H";
            }
            return "S";
        }
        }
    

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }
}
