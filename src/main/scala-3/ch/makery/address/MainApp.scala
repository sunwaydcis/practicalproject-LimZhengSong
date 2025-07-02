package ch.makery.address

import ch.makery.address.model.Person
import javafx.fxml.FXMLLoader
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes.*
import javafx.scene as jfxs
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer

object MainApp extends JFXApp3:

  //Window Root Pane
  var roots: Option[scalafx.scene.layout.BorderPane] = None

  //every person data
  val personData = new ObservableBuffer[Person]()
  personData += new Person("Hans", "Muster")
  personData += new Person("Ruth", "Mueller")
  personData += new Person("Heinz", "Kurz")
  personData += new Person("Cornelia", "Meier")
  personData += new Person("Werner", "Meyer")
  personData += new Person("Lydia", "Kunz")
  personData += new Person("Anna", "Best")
  personData += new Person("Stefan", "Meier")
  personData += new Person("Martin", "Mueller")

  override def start(): Unit =
    // transform path of RootLayout.fxml to URI for resource location.
    val rootResource = getClass.getResource("view/RootLayout.fxml")
    // initialize the loader object.
    val loader = new FXMLLoader(rootResource)
    // Load root layout from fxml file.
    loader.load()

    // retrieve the root component BorderPane from the FXML
    roots = Option(loader.getRoot[jfxs.layout.BorderPane])

    stage = new PrimaryStage():
      title = "AddressApp"
      scene = new Scene():
        root = roots.get

    // call to display PersonOverview when app start
    showPersonOverview()
  // actions for display person overview window
  def showPersonOverview(): Unit =
    val resource = getClass.getResource("view/PersonOverview.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots



  //String Property Demo
  val stringA = new StringProperty("sunway") //publisher
  val stringB = new StringProperty("monash") //subscriber
  val stringC = new StringProperty("inti")

  stringA.onChange((a, b, c) => {
    println("a has change value from " + b + " to " + c)
  })

  stringB.<==(stringA) //when subscriber to publisher is .<==, is mean you set stringB value same as stringA, you cannot direct set stringB value like stringB.value="taylor"
  //stringB <== stringA
  stringC.<==>(stringA) //when subscriber to publisher is .<==>, is mean you set stringC and stringA is using same value, you can direct set stringC or stringA value like stringC.value="taylor"
  //stringC <==> stringA

  stringA.value="segi"
  stringC.value="taylor"

  println("string a view " + stringA.value)
  println("string a view " + stringB.value)
  println("string a view " + stringC.value)

  stringA.value = "monaash"

  val add: (Int, Int)=> Int = (a, b) => {a+b} //function
  println(add(1,2))