/**
 * 
 */
package net.brilliant.osx.helper;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import lombok.Builder;
import net.brilliant.common.CommonUtility;
import net.brilliant.common.ListUtility;
import net.brilliant.exceptions.CommonException;
import net.brilliant.model.ExecutionContext;
import net.brilliant.osx.model.DataWorkbook;
import net.brilliant.osx.model.OSXConstants;
import net.brilliant.osx.model.OfficeMarshalType;
import net.brilliant.osx.model.OsxBucketContainer;

/**
 * @author ducbui
 *
 */
@Builder
public class OfficeSuiteServicesHelper {
	protected ExecutionContext initConfigData(final File zipFile) {
		ExecutionContext executionContext = ExecutionContext.builder().build();

		Map<String, String> secretKeyMap = ListUtility.createMap("Vietbank_14.000.xlsx", "thanhcong");
		Map<String, List<String>> sheetIdMap = ListUtility.createMap();
		sheetIdMap.put("Vietbank_14.000.xlsx", ListUtility.arraysAsList(new String[] {"File Tổng hợp", "Các trưởng phó phòng", "9"}));

		executionContext.put(OSXConstants.COMPRESSED_FILE, zipFile);
		executionContext.put(OSXConstants.ENCRYPTION_KEYS, secretKeyMap);
		executionContext.put(OSXConstants.ZIP_ENTRY, ListUtility.arraysAsList(new String[] {"Vietbank_14.000.xlsx", "data-catalog.xlsx"}));
		executionContext.put(OSXConstants.OFFICE_EXCEL_MARSHALLING_DATA_METHOD, OfficeMarshalType.STREAMING);
		executionContext.put(OSXConstants.PROCESSING_DATASHEET_IDS, sheetIdMap);
		return executionContext;
	}

	public OsxBucketContainer loadDefaultZipConfiguredData(final File sourceZipFile) throws CommonException {
		OsxBucketContainer bucketContainer = null;
		ExecutionContext executionContext = null;
		try {
			executionContext = this.initConfigData(sourceZipFile);
			bucketContainer = OfficeSuiteServiceProvider
					.builder()
					.build()
					.readOfficeDataInZip(executionContext);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return bucketContainer;
	}

	public OsxBucketContainer loadDefaultZipConfiguredData(final ExecutionContext executionContext) throws CommonException {
		return OfficeSuiteServiceProvider
					.builder()
					.build()
					.readOfficeDataInZip(executionContext);
	}

	public OsxBucketContainer loadZipDataFromInputStream(final String originFileName, final InputStream inputStream) throws CommonException {
		OsxBucketContainer bucketContainer = null;
		ExecutionContext executionContext = null;
		File targetDataFile = null;
		try {
			targetDataFile = CommonUtility.createFileFromInputStream(originFileName, inputStream);
			executionContext = this.initConfigData(targetDataFile);
			bucketContainer = OfficeSuiteServiceProvider
					.builder()
					.build()
					.readOfficeDataInZip(executionContext);
		} catch (Exception e) {
			throw new CommonException(e);
		}
		return bucketContainer;
	}

	public DataWorkbook unmarshallContacts(ExecutionContext executionContext) {
		DataWorkbook fetchedDataWorkbook = null;
		return fetchedDataWorkbook;
	}
}
