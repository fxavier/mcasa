const Amenities = () => {
  const amenities = [
    [
      { label: "Sótão" },
      { label: "Quadra de basketbol", defaultChecked: true },
      { label: "ArCondicionado", defaultChecked: true },
      { label: "Gramado", defaultChecked: true },
    ],
    [
      { label: "TV Cabo" },
      { label: "Secador" },
      { label: "Chuveiro ao ar livre" },
      { label: "Máquina de lavar roupa" },
    ],
    [
      { label: "Vista para o lago" },
      { label: "Banheiro" },
      { label: "Quintal frontal" },
      { label: "Refrigerador" },
    ],
  ];

  return (
    <>
      {amenities.map((column, columnIndex) => (
        <div className="col-sm-4" key={columnIndex}>
          <div className="widget-wrapper mb20">
            <div className="checkbox-style1">
              {column.map((amenity, amenityIndex) => (
                <label className="custom_checkbox" key={amenityIndex}>
                  {amenity.label}
                  <input
                    type="checkbox"
                    defaultChecked={amenity.defaultChecked}
                  />
                  <span className="checkmark" />
                </label>
              ))}
            </div>
          </div>
        </div>
      ))}
    </>
  );
};

export default Amenities;
