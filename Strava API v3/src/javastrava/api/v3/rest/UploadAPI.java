package javastrava.api.v3.rest;

import javastrava.api.v3.model.StravaUploadResponse;
import javastrava.api.v3.model.reference.StravaActivityType;
import javastrava.api.v3.rest.async.StravaAPICallback;
import javastrava.api.v3.service.UploadService;
import javastrava.api.v3.service.exception.BadRequestException;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.mime.TypedFile;

/**
 * <p>
 * API definitions for {@link UploadService} endpoints
 * </p>
 *
 * @author Dan Shannon
 *
 */
public interface UploadAPI {
	/**
	 * @see javastrava.api.v3.service.UploadService#checkUploadStatus(Integer)
	 *
	 * @param uploadId The upload id as given back in the response to {@link #upload(StravaActivityType, String, String, Boolean, Boolean, String, String, TypedFile)}
	 * @return Upload response containing the upload id and activity id and current status of the upload
	 */
	@GET("/uploads/{id}")
	public StravaUploadResponse checkUploadStatus(@Path("id") final Integer uploadId);

	/**
	 * @see javastrava.api.v3.service.UploadService#checkUploadStatus(Integer)
	 *
	 * @param uploadId The upload id as given back in the response to {@link #upload(StravaActivityType, String, String, Boolean, Boolean, String, String, TypedFile, StravaAPICallback)}
	 * @param callback The callback to execute on completion
	 */
	@GET("/uploads/{id}")
	public void checkUploadStatus(@Path("id") final Integer uploadId, StravaAPICallback<StravaUploadResponse> callback);

	/**
	 * @see javastrava.api.v3.service.UploadService#upload(StravaActivityType, String, String, Boolean, Boolean, String, String, java.io.File)
	 *
	 * @param activityType Type of activity being uploaded
	 * @param name Name of the activity
	 * @param description (Optional) Description of the activity
	 * @param _private (Optional) Whether the activity should be flagged as private
	 * @param trainer (Optional) If <code>true</code> then the activity was done on a stationary trainer
	 * @param dataType Type of data file being uploaded
	 * @param externalId (Optional) External identifier generated by your application which Strava will later use as a reference when you're checking upload status
	 * @param file The file to be uploaded!
	 * @return Upload response containing the upload id and activity id and current status of the upload
	 * @throws BadRequestException If required elements of the call are missing
	 */
	@Multipart
	@POST("/uploads")
	public StravaUploadResponse upload(@Part("activity_type") final StravaActivityType activityType, @Part("name") final String name,
			@Part("description") final String description, @Part("private") final Boolean _private, @Part("trainer") final Boolean trainer, @Part("data_type") final String dataType,
			@Part("external_id") final String externalId, @Part("file") final TypedFile file) throws BadRequestException;

	/**
	 * @see javastrava.api.v3.service.UploadService#upload(StravaActivityType, String, String, Boolean, Boolean, String, String, java.io.File)
	 *
	 * @param activityType Type of activity being uploaded
	 * @param name Name of the activity
	 * @param description (Optional) Description of the activity
	 * @param _private (Optional) Whether the activity should be flagged as private
	 * @param trainer (Optional) If <code>true</code> then the activity was done on a stationary trainer
	 * @param dataType Type of data file being uploaded
	 * @param externalId (Optional) External identifier generated by your application which Strava will later use as a reference when you're checking upload status
	 * @param file The file to be uploaded!
	 * @param callback The callback to execute on completion
	 * @throws BadRequestException If required elements of the call are missing
	 */
	@Multipart
	@POST("/uploads")
	public void upload(@Part("activity_type") final StravaActivityType activityType, @Part("name") final String name,
			@Part("description") final String description, @Part("private") final Boolean _private, @Part("trainer") final Boolean trainer, @Part("data_type") final String dataType,
			@Part("external_id") final String externalId, @Part("file") final TypedFile file, final StravaAPICallback<StravaUploadResponse> callback) throws BadRequestException;

}
