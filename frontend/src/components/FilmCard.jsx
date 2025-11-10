import { getTRFormattedDate } from './../utility/DateUtilities';

export default function FilmCard({ film }) {
  return (
    <div className="card mb-4" style={{ width: "18rem" }}>
      <img
        src="https://picsum.photos/id/237/300/400"
        className="card-img-top"
        alt={film.title}
      />
      <div className="card-body">
        <h5 className="card-title">{film.baslik}</h5>
        <p className="card-text">
        
          {getTRFormattedDate(film.yayinTarihi?.substring(0, 10))} • ⭐ {film.puani ?? "-"}
        </p>
      </div>
    </div>
  );
}