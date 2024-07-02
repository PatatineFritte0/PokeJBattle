Requisiti minimi: avere almeno un display 1920x1080 :(


istruzioni per avviare il programma

1) importare il progetto su eclipse
2) inserire in run configuration -> dipendencies -> classpath -> add jar -> andare in lib e cliccare su gson.jar (è possibile che sia gia presente in modulepath, rimuovetelo e aggiungetelo in classpath)
3) inserire in run configuration -> arguments -> Vm arguments -> --module-path lib/JavaFx/javafx-sdk-22.0.1/lib --add-modules=javafx.controls,javafx.fxml
4) assicurarsi che in run configuration -> JRE ce ne sia una valida
5) andare nella build path e controllare se la JRE non dia problemi, in caso contrario, consiglio di inserire la stessa JRE del run configuration
