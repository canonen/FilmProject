import axios from "axios";

export const getRecentMovies = async (page = 0, size = 20) => {
    const response = await axios.get('http://localhost:8080/api/film/recent-movies',
        {
            params:{page, size},
            withCredentials: true
        }
         )
    return response.data;
}