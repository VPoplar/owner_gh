package spark_core.framework.common

import spark_core.framework.util.EnvUtil

trait TDao {

    def readFile(path:String) = {
        EnvUtil.take().textFile(path)
    }
}
