package singleton

/**
 * Initialize the datasource and the database pooled connection
 */
object DbConfig {
//    lateinit var db: org.jetbrains.exposed.sql.Database
//    lateinit var dataSource: DataSource
//
//    fun configure(config: Config) {
//        val hikariConfig = HikariConfig()
//        hikariConfig.driverClassName = config[Database.driverClassName]
//        hikariConfig.jdbcUrl = config[Database.jdbcUrl]
//        hikariConfig.username = config[Database.username]
//        hikariConfig.password = config[Database.password]
//        hikariConfig.maximumPoolSize = config[Database.maxPoolSize]
//        hikariConfig.isAutoCommit = config[Database.isAutoCommit]
//        hikariConfig.validate()
//        dataSource = HikariDataSource(hikariConfig)
//        db = org.jetbrains.exposed.sql.Database.connect(dataSource)
//    }
}