package test.api.model.reference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import stravajava.api.v3.model.reference.StravaStreamSeriesDownsamplingType;

/**
 * @author dshannon
 *
 */
public class StravaStreamSeriesDownsamplingTypeTest {
	@Test
	public void testGetId() {
		for (StravaStreamSeriesDownsamplingType type : StravaStreamSeriesDownsamplingType.values()) {
			assertNotNull(type.getId());
			assertEquals(type,StravaStreamSeriesDownsamplingType.create(type.getId()));
		}
	}
	
	@Test
	public void testGetDescription() {
		for (StravaStreamSeriesDownsamplingType type : StravaStreamSeriesDownsamplingType.values()) {
			assertNotNull(type.getDescription());
		}
	}

}
