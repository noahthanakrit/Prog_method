n = int(input())
times = {}
temps = []
songs = {}

def total_time(time):
    minute,second = time.split(':')
    minute = int(minute)
    second = int(second)
    total_second = (60*minute) + second
    return total_second

def convert_to_time(total):
    dmin = total // 60
    ds = total - (dmin*60)
    if ds < 10:
        return f'{dmin}:0{ds}'
    else:
        return f'{dmin}:{ds}'

for _ in range(n):
    name,singer,branch,time = input().split(',')
    branch = branch.strip()
    if branch not in times:
        times[branch] = total_time(time)
    else:
        times[branch] += total_time(time)

for n in times.keys():
    temps.append([times[n], n])
    temps.sort(reverse = True)
    
for ti,ty in temps[:3]:
    songs[ty] = convert_to_time(ti)

for ans in songs.keys():
    print(ans, '-->', songs[ans])