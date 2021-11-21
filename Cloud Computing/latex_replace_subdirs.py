import re
import os

for dir in os.walk(os.getcwd()):
    for filename in os.listdir(dir[0]):
        if (filename.endswith('tex') and ('edited' not in filename)): 
            try:
                file = open(dir[0] + '\\' + filename, encoding="utf8")
                file_contents = file.read()
                regex_get_name="(?<=\/)[\w\d\s\[\]\(\)\_\,\.\-]+[jpng]{3}"
                entries=re.findall(regex_get_name, file_contents)

                file = open(dir[0] + '\\' + filename, encoding="utf8")
                regex_replace='\{[\s\S]+\}'
                for line in file.readlines():
                    if '\\caption' in line:
                        line = re.sub(r'\{[\s\S]+\}', '{' + entries.pop(0) + '}', line)
                    file=open(dir[0] + '\\' + filename[:-4] + '_edited.tex', 'a').write(line)
                # print(dir[0] + '\\' +filename)
                file.close()
            except:
                pass