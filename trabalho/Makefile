# Nome do arquivo .java principal
MAIN = BancoImobiliario

# Variável para os arquivos .java
SOURCES = $(wildcard *.java)

# Variável para os arquivos .class correspondentes
CLASSES = $(SOURCES:.java=.class)

# Variável para o compilador Java
JAVAC = javac

# Variável para o comando Java
JAVA = java

# Alvo principal para compilar e executar o programa
all: $(MAIN) run

# Compilar o arquivo principal e dependências
$(MAIN): $(CLASSES)

%.class: %.java
	$(JAVAC) $<

# Executa o programa
run:
	$(JAVA) $(MAIN)

# Limpa os arquivos .class
clean:
	rm -f *.class
