paker: turnableAnimation animation gameLogic pakermanEntity pakermanPlayer pakerWindow particles
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
	
particles:
	javac particles.java
	
clean:
	rm *.class