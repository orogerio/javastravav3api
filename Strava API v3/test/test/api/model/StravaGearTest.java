package test.api.model;

import stravajava.api.v3.model.StravaGear;
import test.utils.BeanTest;

/**
 * @author dshannon
 *
 */
public class StravaGearTest extends BeanTest<StravaGear> {

	@Override
	protected Class<StravaGear> getClassUnderTest() {
		return StravaGear.class;
	}

}
