class sample{
    /*****************PROBLEM-1***************/
    /*****************PROBLEM-2***************/
    //tc:0(kl+mn) m=length of userSongs, l=o.of songs,k=length of songsGenre ,n=no.of users
        //sc:0(k+n)
    public class Main {

        public static Map<String, List<String>> favoritegenre(HashMap<String, List<String>> userSongs,HashMap<String, List<String>> songGenres){
            Map<String, List<String>> result=new HashMap<>();
            HashMap<String,String> songGenreMap=new HashMap<>();
            for(String key:songGenres.keySet()){
                List<String> songs=songGenres.get(key);
                for(String song:songs){
                    songGenreMap.put(song,key);
                }
            }

            for(String key:userSongs.keySet()){
                int max=0;

                HashMap<String,Integer> freq=new HashMap<>();
                List<String> songs=userSongs.get(key);
                for(String song:songs){
                    String genre=songGenreMap.get(song);
                    freq.put(genre,freq.getOrDefault(genre,0)+1);
                    max=Math.max(max,freq.get(genre));
                }
                for(String genre:freq.keySet()){
                    if(freq.get(genre)==max){
                        if(!result.containsKey(key)){
                            result.put(key,new ArrayList<>());
                        }
                        result.get(key).add(genre);
                    }
                }
            }
            return result;
        }

        public static void main(String[] args) {
            HashMap<String, List<String>> userSongs = new HashMap<>();
            userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));
            userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

            HashMap<String, List<String>> songGenres = new HashMap<>();
            songGenres.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));
            songGenres.put("Dubstep", Arrays.asList(new String[]{"song7"}));
            songGenres.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));
            songGenres.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));
            songGenres.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

            Map<String, List<String>> res = favoritegenre(userSongs, songGenres);
            System.out.println(res);
        }
    }
}