counter=0
stringBuffer=""
tail -f "/tmp/log-generator.log" | while read line; do
    if [ $counter -eq 0 ]
    then
        stringBuffer=""
    fi
    stringBuffer="$stringBuffer\n$line"
    counter=$((counter+1))
    if [ $counter -eq 1000 ]
    then
        today=`date +%Y_%m_%d_%H_%M_%S`
        filename="/home/elbatouri/Desktop/TECH-GADGET-RECOMMENDATIONS/structured-streaming/src/main/resources/data/$today.log"
        echo -e "$stringBuffer" > $filename
        counter=0
    fi
done