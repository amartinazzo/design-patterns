run:
	kotlinc $(f).kt -include-runtime -d $(f).jar && java -jar $(f).jar

clean:
	rm *.jar *.class