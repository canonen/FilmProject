import { useCallback, useEffect, useRef, useState } from "react";
import { getRecentMovies } from "../services/FilmService";
import FilmCard from './FilmCard';

export default function FilmList(){

    const [filmList, setFilmList] = useState([]);
    const [page, setPage] = useState(0);
    const [hasMoreFilm, setHasMoreFilm] = useState(true);
    const [isLoading, setLoading] = useState(false);

    useEffect(()=>{
        const fetchFilms = async () => {
            setLoading(true);
            const newFilms = await getRecentMovies(page, 20);
            setFilmList((mainList)=> [...mainList, ...newFilms]);
            setHasMoreFilm(newFilms.length > 0)
            setLoading(false);
        }
        fetchFilms();
    }, [page])

    const observer = useRef();

    const lastFilmRef = useCallback((node) => {
        if(isLoading) return;
        if(observer.current) observer.current.disconnect();
        observer.current = new IntersectionObserver((entries) => {
            if (entries[0].isIntersecting && hasMoreFilm) {
                setPage((prevPage) => prevPage + 1);
            }
        });
          if (node) observer.current.observe(node);
    })

   return (
    <>
      <div className="container">
        <div className="row">
          {filmList.map((film, index) => {
            const isLast = index === filmList.length - 1;
            return (
              <div
                className="col-12 col-sm-6 col-md-4 col-lg-3"
                key={film.id}
                ref={isLast ? lastFilmRef : null}
              >
                <FilmCard film={film} />
              </div>
            );
          })}
        </div>
      </div>
      {isLoading && <p className="text-center mt-3">Yükleniyor...</p>}
    </>
  );
};

