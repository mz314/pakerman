paker: turnableAnimation animation gameLogic pakermanEntity pakermanPlayer pakerWindow
	javac paker.java
	
animation:
	javac animation.java

turnableAnimation: animation
	javac turnableAnimation.java
	
gameLogic:
	javac gameLogic.java
	
pakermanEntity:
	javac pakermanEntity.java
pakermanPlayer:
	javac pakermanPlayer.java
	
pakerWindow:
	javac pakerWindow.java
	
clean:
	rm *.class