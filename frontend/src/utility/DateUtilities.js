export const getTRFormattedDate =  (dateString) => {
    const date = new Date(dateString)

    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Ay 0-11 arası olduğu için 1 ekliyoruz
    const year = date.getFullYear();

      return `${day}/${month}/${year}`;
};
