package info.ashutosh.config;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.CompositeDatabasePopulator;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
public class DataInitializationConfig {

	private final static Logger LOGGER = Logger.getLogger(DataInitializationConfig.class.getName());

	/**
	 * Configures a DataSourceInitializer to create schemas and populate the
	 * database with initial data from the "data.sql" script. This method is
	 * conditionally enabled based on the value of the "custom.data.init.enabled"
	 * property.
	 *
	 * @param dataSource The DataSource to be initialized with data.
	 * @return DataSourceInitializer instance responsible for populating the
	 *         database.
	 */
	@Bean
	@ConditionalOnProperty(name = "custom.data.init.enabled", havingValue = "true")
	public DataSourceInitializer dataSourceInitializer(DataSource dataSource) {

		LOGGER.info("DataSourceInitializer : Executing Schema Populator..");

		DataSourceInitializer initializer = new DataSourceInitializer();
		initializer.setDataSource(dataSource);

		// Add schema creation script
		ResourceDatabasePopulator schemaPopulator = new ResourceDatabasePopulator();
		schemaPopulator.addScript(new ClassPathResource("schemas/schema.sql"));

		// Add data insertion script
		ResourceDatabasePopulator dataPopulator = new ResourceDatabasePopulator();
		dataPopulator.addScript(new ClassPathResource("schemas/data.sql"));

		initializer.setDatabasePopulator(new CompositeDatabasePopulator(schemaPopulator, dataPopulator));

		LOGGER.info("DataSourceInitializer : Schemas and Data are Imported");
		return initializer;
	}
}
