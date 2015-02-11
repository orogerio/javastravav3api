package stravajava.api.v3.model.reference;

/**
 * @author Dan Shannon
 *
 */
public enum StravaStreamResolutionType {
	LOW("low", "low", 100), MEDIUM("medium", "medium", 1000), HIGH("high", "high", 10000), UNKNOWN("UNKNOWN", "Unknown", 0);

	private String id;
	private String description;
	private int size;

	private StravaStreamResolutionType(String id, String description, Integer size) {
		this.id = id;
		this.description = description;
		this.size = size;
	}

	// @JsonValue
	public String getValue() {
		return this.id;
	}

	// @JsonCreator
	public static StravaStreamResolutionType create(String id) {
		StravaStreamResolutionType[] types = StravaStreamResolutionType.values();
		for (StravaStreamResolutionType type : types) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		return StravaStreamResolutionType.UNKNOWN;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return this.id;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return this.size;
	}
}
