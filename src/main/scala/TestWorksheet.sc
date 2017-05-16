
val f: () => Unit = () => {println("test")}

f()


import scala.collection.mutable.ListBuffer
import scala.io.Source
import scala.collection.mutable.Map

val fileName = "/Users/tipputa/study/170130_gunma/reference/ZHP_lib.msp"
val lines = Source.fromFile(fileName).getLines().toList


class Compound(l: List[String]){
  var keys = Map.empty[String, String]
  private val list = l
  for(tag <- list) {
    if (tag.contains(":")) {
      val tagSplit = tag.split(":", 2).map(_.trim)
      println(tagSplit(0))
      println(tagSplit(1))
      keys update(tagSplit(0), tagSplit(1))
    }
  }
  //override def toString = compName + " " + CE*/
  //def count = l.count()
}


def readMsp (file : String): List[Compound] ={
  val lines = Source.fromFile(file).getLines().toList
  def sliceMsp(l: List[String], l2: ListBuffer[Compound]): List[Compound] = {
    val a = new ListBuffer[String]
    var these = l
    var list2 = l2
    while (these.length > 0 && these.head.nonEmpty) {
      a += these.head
      these = these.tail
    }
    list2 += new Compound(a.toList)
    var next = these.tail
    if(next.head.isEmpty){
      while (next.length > 0 && next.head.isEmpty){
        next = next.tail
      }
    }
    if(next.length > 3) {
      sliceMsp(next, list2)
    } else {
      list2.toList
    }
  }
  val comp = ListBuffer[Compound]()
  val compounds = sliceMsp(lines, comp)
  compounds
}

val comp = readMsp(fileName)
val i = comp(1).keys.iterator
while(i.hasNext) {
  val (k,v) = i.next
  println(k + "=" + v)
}


/*def checkTag(l: List[Compound]): List[String] = {
  var output = new ListBuffer[String]
  for (list <- l){
    for (line <- list){
      if (line.matches("*:*")){
        val tag = line.split(":").map(_.trim)
        println(tag)
      }
    }
  }
}
checkTag(comp)*/
