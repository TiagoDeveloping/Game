package testing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Enemy.Enemy;
import Enemy.EnemyTrajectory;
import player.Location;

class EnemySpecification {
	
	@Test
	void enemyNotAllowedToPassTopBorder() {
		Enemy e = new Enemy(0, new Location(5,5), Color.yellow);
		e.setLocation(new Location(50, 0));
		
		assertThat(e.hasBounced(), is(true));
	}
	@Test
	void enemyWithinBoundaries() {
		Enemy e = new Enemy(0, new Location(5,5), Color.yellow);
		e.setLocation(new Location(50, 1));
		
		assertThat(e.hasBounced(), is(false));
	}
	
	@Test
	void enemyBoucneAtXBigger900() {
		Enemy e = new Enemy(0, new Location(5,5), Color.yellow);
		e.setLocation(new Location(901, 50));
		
		assertThat(e.hasBounced(), is(true));
	}
	
	@Test
	void doesEnemyFollowStrateLineLeft() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setDirection(-1);
		
		e.move();
		
		int x = e.getEnemyLocation().getX();
		int y = e.getEnemyLocation().getY();
		
		assertThat(x, is(99));
		assertThat(y, is(110));
	}
	
	@Test
	void doesEnemyFollowStrateLineRight() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setDirection(1);
		
		e.move();
		
		int x = e.getEnemyLocation().getX();
		int y = e.getEnemyLocation().getY();
		
		assertThat(x, is(101));
		assertThat(y, is(90));
	}
	
	@Test
	void doesEnemyFollowStrateLineRightNegativeRC() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setEnemyTrajectory(new EnemyTrajectory(100, 100, -10));
		
		e.setDirection(1);
		
		e.move();
		
		int x = e.getEnemyLocation().getX();
		int y = e.getEnemyLocation().getY();
		
		assertThat(x, is(101));
		assertThat(y, is(110));
	}
	
	@Test
	void doesEnemyFollowStrateLineLeftNegativeRC() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setEnemyTrajectory(new EnemyTrajectory(100, 100, -10));
		
		e.setDirection(-1);
		
		e.move();
		
		int x = e.getEnemyLocation().getX();
		int y = e.getEnemyLocation().getY();
		
		assertThat(x, is(99));
		assertThat(y, is(90));
	}
	
	@Test
	void doesEnemyStayWithinBoundaries() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setEnemyTrajectory(new EnemyTrajectory(100, 100, -10));
		
		e.setDirection(-1);
		
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		
		int x = e.getEnemyLocation().getX();
		int y = e.getEnemyLocation().getY();
		
		assertThat(x, is(90));
		assertThat(y, is(0));
		
		assertThat(e.isWithinBoundaries(), is(false));
		
		e.getEnemyTrajectory().flipRc();
		
		for (int i = 0; i < 70; i++) {
			e.move();
		}
		
		x = e.getEnemyLocation().getX();
		y = e.getEnemyLocation().getY();
		
		assertThat(x, is(20));
		assertThat(y, is(700));
		
		assertThat(e.isWithinBoundaries(), is(false));
	}
	
	@Test
	void hasEnemyBounced() {
		Enemy e = new Enemy(0, new Location(100, 100), Color.yellow);
		
		e.setEnemyTrajectory(new EnemyTrajectory(100, 100, -10));
		
		e.setDirection(-1);
		
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		e.move();
		
		assertThat(e.hasBounced(), is(true));
	}
	
}
