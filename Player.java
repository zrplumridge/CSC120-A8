public class Player implements Contract{
    
    String itemInHand;
    int playerX = 0;
    int playerY = 0;
    boolean hasWings = false;
    int tiredness = 0;
    int livesLeft = 10;

    public Player(String name) {

    }

    public void grab(String item){
        itemInHand = item;
        System.out.println("You grabbed " + item);
    }

    public String drop(String item){
        itemInHand = null;
        System.out.println("You dropped " + item);
        return item;
    }

    public void examine(String item){
        if (itemInHand != null){
            System.out.println("You examined " + item);
        } else {
            System.out.println("There is nothing in your hand. Grab something to examine it. ");
        }
    }

    public void use(String item){
        if (itemInHand == "wings"){
            hasWings = true;
            System.out.println("You can now fly!");
            itemInHand = null;
        }
    }

    public boolean walk(String direction){
        if (direction == "n" && playerY < 20){
            playerY ++;
            return true;
        } else if (direction == "s" && playerY > -20){
            playerY --;
            return true;
        } else if (direction == "e" && playerX < 20){
            playerX ++;
            return true;
        } else if (direction == "w" && playerX > -20){
            playerX --;
            return true;
        } else {
            System.out.println("You can no longer move in that direction. ");
            return false;
        }
    }

    public boolean fly(int x, int y){
        if (hasWings) {
            playerX = x;
            playerY = y;
            tiredness += 10;
            return true;
        } else {
            return false;
        }
    }

    public Number shrink(){
        livesLeft--;
        return livesLeft;
    }

    public Number grow(){
        livesLeft++;
        return livesLeft;
    }

    public void rest(){
        tiredness = 0;
    }

    public void undo(){
        //un-use item?
    }

    public static void main(String[] args){
        Player zip = new Player("Zip");
        
        zip.fly(2, 5);
        zip.grab("wings");
        zip.use("wings");
        zip.fly(3, 4);
    }
}