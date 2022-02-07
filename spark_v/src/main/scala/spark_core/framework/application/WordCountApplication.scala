package spark_core.framework.application

import spark_core.framework.common.TApplication
import spark_core.framework.controller.WordCountController

object WordCountApplication extends App with TApplication{

    // 启动应用程序
    start(){
        val controller = new WordCountController()
        controller.dispatch()
    }

}
