package test

import java.io.ObjectInputStream
import java.net.ServerSocket

object Executor2 {
  def main(args: Array[String]): Unit = {
    // 启动服务器接受数据
    val serverSocket = new ServerSocket(8888)
    println("服务器2启动，等待接收数据")
    //等待客户端的连接
    val client = serverSocket.accept()
    val in = client.getInputStream
    val stream = new ObjectInputStream(in)
    val task: SubTask = stream.readObject().asInstanceOf[SubTask]
    val ints: List[Int] = task.compute()
    println("客户端接收的数据为：",ints)
    stream.close()
    client.close()
    serverSocket.close()
  }
}
