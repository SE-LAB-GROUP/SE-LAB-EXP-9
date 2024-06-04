package com.unittest.codecoverage.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.unittest.codecoverage.exceptions.BehaviorException;
import com.unittest.codecoverage.models.Footpassenger;
import com.unittest.codecoverage.models.Traffic;
import com.unittest.codecoverage.models.TrafficLigth;
import com.unittest.codecoverage.services.TrafficBehaviorService;
import com.unittest.codecoverage.services.impl.TrafficBehaviorServiceImpl;
import com.unittest.codecoverage.models.StreetDirectionFlow;


public class TrafficBehaviorServiceTest {
	
	private TrafficBehaviorService trafficBehaviorService = new TrafficBehaviorServiceImpl();
	
	@Test
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficAndWhileTheTrafficLightIsRed() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.RED);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessageContaining("You should'nt do that, reckless person");
		
	}
	
	@Test
	@DisplayName("Should throw exception when footpassenger crosses the road during heavy traffic without attention")
	public void testFootpassengerCrossTheStreet_shouldThrowBehaviorExceptionWhenFootpassengerCrossesTheRoadDuringHeavyTrafficWithoutLookSides() {
	
		Traffic currentTrafic = new Traffic();
		currentTrafic.setIntenseCarTraffic(true);
		
		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(false);
		currentFootpassengerBehavior.setLookedToTheRight(false);
		
		Assertions.assertThatThrownBy(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTrafic, currentFootpassengerBehavior))
			.isInstanceOf(BehaviorException.class)
			.hasMessage("You should be more careful");
		
	}
	@Test
	public void testTrafficSettersAndGetters() {
		Traffic traffic = new Traffic();

		traffic.setIntenseCarTraffic(true);
		traffic.setMaxSpeedAllowed((short) 60);
		traffic.setMinSpeedAllowed((short) 30);
		traffic.setCurrentTrafficLight(TrafficLigth.GREEN);
		traffic.setStreetDirectionFlow(StreetDirectionFlow.TWO_WAY);

		Assertions.assertThat(traffic.intenseCarTraffic()).isTrue();
		Assertions.assertThat(traffic.getMaxSpeedAllowed()).isEqualTo((short) 60);
		Assertions.assertThat(traffic.getMinSpeedAllowed()).isEqualTo((short) 30);
		Assertions.assertThat(traffic.getCurrentTrafficLight()).isEqualTo(TrafficLigth.GREEN);
		Assertions.assertThat(traffic.getStreetDirectionFlow()).isEqualTo(StreetDirectionFlow.TWO_WAY);
	}

	@Test
	public void testFootpassengerSettersAndGetters() {
		Footpassenger footpassenger = new Footpassenger();

		footpassenger.setCrossedTheCrosswalk(true);
		footpassenger.setCrossedTrafficLigth(TrafficLigth.RED);
		footpassenger.setLookedToTheLeft(true);
		footpassenger.setLookedToTheRight(false);
		footpassenger.setCrossedTheRoad(true);

		Assertions.assertThat(footpassenger.crossedTheCrosswalk()).isTrue();
		Assertions.assertThat(footpassenger.getCrossedTrafficLigth()).isEqualTo(TrafficLigth.RED);
		Assertions.assertThat(footpassenger.lookedToTheLeft()).isTrue();
		Assertions.assertThat(footpassenger.lookedToTheRight()).isFalse();
		Assertions.assertThat(footpassenger.crossedTheRoad()).isTrue();
	}

	@Test
	@DisplayName("Should allow footpassenger to cross during light traffic and green light")
	public void testFootpassengerCrossTheStreet_shouldAllowCrossingWhenLightTrafficAndGreenLight() {
		Traffic currentTraffic = new Traffic();
		currentTraffic.setIntenseCarTraffic(false);

		Footpassenger currentFootpassengerBehavior = new Footpassenger();
		currentFootpassengerBehavior.setCrossedTheRoad(true);
		currentFootpassengerBehavior.setCrossedTrafficLigth(TrafficLigth.GREEN);
		currentFootpassengerBehavior.setLookedToTheLeft(true);
		currentFootpassengerBehavior.setLookedToTheRight(true);

		Assertions.assertThatCode(() -> trafficBehaviorService.footpassengerCrossTheStreet(currentTraffic, currentFootpassengerBehavior))
			.doesNotThrowAnyException();
	}

}
