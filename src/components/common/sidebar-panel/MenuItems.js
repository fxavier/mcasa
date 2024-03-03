const MenuItems = () => {
  const menuItems = [
    { id: 1, title: "Apartmentos" },
    { id: 2, title: "Vivendas" },
    { id: 3, title: "Casas" },
    { id: 4, title: "Armazém" },
    { id: 5, title: "Escritório" },
    { id: 6, title: "Terreno" },
    { id: 7, title: "Loja" },
  ];

  return (
    <ul className="navbar-nav">
      {menuItems.map((item) => (
        <li className="nav-item" key={item.id}>
          <a className="nav-link" href="#" role="button">
            {item.title}
          </a>
        </li>
      ))}
    </ul>
  );
};

export default MenuItems;
