package com.anhkiet.cdio4_api.controller

import com.anhkiet.cdio4_api.entities.*
import com.anhkiet.cdio4_api.helper.responseHelper.content
import com.anhkiet.cdio4_api.helper.responseHelper.response
import com.anhkiet.cdio4_api.repositories.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.util.*

@RestController
@RequestMapping("/api")
class DemoController(
    private val accountRepository: AccountRepository,
    private val addressRepository: AddressRepository,
    private val projectRepository: ProjectRepository,
    private val houseRepository: HouseRepository,
    private val houseInfoRepository: HouseInfoRepository,
    private val houseImagesRepository: HouseImagesRepository,
    private val houseTypeRepository: HouseTypeRepository
) {
//    @GetMapping("/gHouseType")
//    fun gHouseTypei() = response {
//        houseTypeRepository.saveAll(gHouseType())
//        content(
//            "ok"
//        )
//    }
//
//    @GetMapping("/gHouseInfo")
//    fun gHouseInfoi() = response {
//        houseInfoRepository.saveAll(gHouseInfo())
//        content(
//            "ok"
//        )
//    }
//
//    @GetMapping("/gHouseImage")
//    fun gHouseImagei() = response {
//        houseImagesRepository.saveAll(gHouseImage())
//        content(
//            "ok"
//        )
//    }
//
//    @GetMapping("/gProject")
//    fun gProjecti() = response {
//        projectRepository.saveAll(gProject())
//        content(
//            "ok"
//        )
//    }
//
//    @GetMapping("/gAddress")
//    fun gAddressi() = response {
//        addressRepository.saveAll(gAddress())
//        content(
//            "ok"
//        )
//    }

    @GetMapping("/gAccount")
    fun gAccounti() = response {
        accountRepository.save(gAccount())
        content(
            "ok"
        )
    }

    @GetMapping("/gHouse")
    fun gHousei() = response {
        houseRepository.saveAll(gHouse())
        houseImagesRepository.saveAll(gImages())
        //houseImagesRepository.saveAll(gHouseImage(gHouse()))
        content(
            "ok"
        )
    }

    fun gImages(): List<HouseImages> {
        val houseInfos = houseInfoRepository.findAll()
        var arr = emptyList<HouseImages>()
        for (house in houseInfos) {
            arr = arr.plus(
                listOf(
                    "https://file4.batdongsan.com.vn/2023/04/17/20230417230210-69b7_wm.jpg",
                    "https://file4.batdongsan.com.vn/2023/04/17/20230417230218-7f65_wm.jpg",
                    "https://file4.batdongsan.com.vn/2023/04/17/20230417230207-a221_wm.jpg",
                    "https://file4.batdongsan.com.vn/2023/04/17/20230417230207-a221_wm.jpg",
                    "https://file4.batdongsan.com.vn/2023/04/17/20230417230205-1b13_wm.jpg",
                ).map {
                    val houseImages = HouseImages()
                    houseImages.imageUrl = it
                    houseImages.houseImageHouseInfos = house
                    houseImages
                }
            )
        }
        return arr
    }

    fun gAccount() : Account {
        val account = Account()
        account.email = "igg.anhkiet1@gmail.com"
        account.password = "\$2a\$10\$586KH/byBGSwvtYsUZxdoOB5LG5nNXyAMup9Ud642utkOYggDx5Z6"
        account.role = "admin"
        return account
    }

    fun gAddress() : List<Address> {
        val p = listOf(
            "Thanh Hóa",
            "Bình Dương",
            "Kiên Giang",
            "Bình Dương",
            "Bắc Ninh"
        )
        val d = listOf(
            "hành phố Thanh Hóa",
            "TP. Dĩ An",
            "Thành phố Phú Quốc",
            "TP. Dĩ An",
            "Thành phố Từ Sơn"
        )
        val w = listOf(
            "Đông Tân",
            "Phường Dĩ An",
            "Gành Dầu",
            "Phường Bình Thắng",
            "Phường Phù Chẩn,"
        )
        val s = listOf(
            "Đại Lộ Đông Tây",
            "Số nhà 29, Đường số 3, Khu phố Thống Nhất 1",
            "Bãi Dài",
            "Khu phố Hiệp Thắng",
            "KĐT Centa City, Khu liên hợp đô thị - công nghiệp – dịch vụ VSIP Bắc Ninh"
        )
        var arr = emptyList<Address>()
        for (i in 0..4) {
            val a = Address()
            a.province = p[i]
            a.district = d[i]
            a.wards = w[i]
            a.street = s[i]
            arr = arr.plus(a)
        }
        return arr
    }

    fun gProject() : List<Project> {
        val name = listOf(
            "Khu dân cư 8315 Đông Tân",
            "Tòa nhà Bcons Tower VI",
            "The 5Way Phú Quốc",
            "Bcons Bình Thắng",
            "Centa River Park"
        )
        val des = listOf(
            "Dự án Khu dân cư 8315 Đông Tân (Mặt bằng 8315 Đông Tân hay MBQH 8315) là khu đất nền đấu giá tại phường Đông Tân, TP. Thanh Hóa, tỉnh Thanh Hóa. Dự án có quy mô hơn 8000m2, gồm 100 lô đất nền liền kề với diện tích từ 80m2.\n" +
                    "\n" +
                    "\n" +
                    "Vị trí\n" +
                    "Vị trí dự án Khu dân cư 8315 Đông Tân nằm trên đường Đại lộ Đông Tây, thuộc địa phận phường Đông Tân, phía Tây TP. Thanh Hóa, cách trung tâm thành phố khoảng 4km. Từ dự án Khu dân cư 8315 Đông Tân đi đến các khu vực, tiện ích lân cận đều thuận tiện nhờ các tuyến giao thông chính như Đại lộ Đông Tây, Quốc lộ 47, đường vành đai phía Tây, cao tốc Bắc-Nam,…\n" +
                    "\n" +
                    "Các mặt tiếp giáp với mặt bằng 8315 Đông Tân:\n" +
                    "\n" +
                    "Phía Bắc: Giáp Đại lộ Đông Tây\n" +
                    "Phía Nam: Giáp cây xanh và đất giáo dục\n" +
                    "Phía Đông: Giáp đường Trần Hưng Đạo\n" +
                    "Phía Tây: Giáp cây xanh và khu dân cư mới\n" +
                    "\n" +
                    "Vị trí dự án Khu dân cư 8315 Đông Tân - TP. Thanh Hóa\n" +
                    "Khoảng cách từ Khu dân cư 8315 phường Đông Tân đến các địa điểm, tiện ích nổi bật của khu vực lân cận:\n" +
                    "\n" +
                    "100m đến khu đô thị mới TT Rừng Thông, MB Đồng Vèn\n" +
                    "200m đến trung tâm hành chính huyện Đông Sơn\n" +
                    "300m đường vành đai phía Tây\n" +
                    "500m dến KDC Minh Tuấn,  chợ đầu mối\n" +
                    "Trong bán kính 2km là bệnh viện đa khoa huyện, trường cấp 3 Đông Sơn I, bệnh viện đa khoa Phúc Thịnh, các mặt bằng Đại đô thị Đông Sơn (1879, 767, 258, 3220, 2652….)\n" +
                    "3km đến cao tốc Bắc Nam\n" +
                    "4km đến bưu điện tỉnh Thanh Hóa\n" +
                    "28km đến sân bay Thọ Xuân\n" +
                    "Tiện ích\n" +
                    "Dự án đất nền MB 8315 Đông Tân được quy hoạch đồng bộ với các tiện ích đi kèm như:\n" +
                    "\n" +
                    "Công viên cây xanh\n" +
                    "Nhà văn hoá\n" +
                    "Khu liên hợp thể dục thể thao\n" +
                    "Hạ tầng giao thông được chỉnh trang hiện đại với các trục đường rộng, thoáng\n" +
                    "Mặt bằng 8315 Đông Tân nằm dọc theo đường Đại lộ Đông Tây kết nối TP. Thanh Hoá với trung tâm huyện Đông Sơn, lòng đường rộng từ 7,5 – 15m giúp việc lưu thông cho các phương tiện được nhanh chóng, thuận lợi.\n" +
                    "\n" +
                    "Mặt bằng - Thiết kế\n" +
                    "Mặt bằng 8315 Đông Tân – Tp Thanh Hoá được chia làm 6 khu (A,B,C,D,E,F) với 212 lô. Đơt đấu giá 6/6 sẽ đấu giá 100 lô thuộc các phân khu A,B,C,D. Thông tin cụ thể như sau:\n" +
                    "\n" +
                    "Khu A: gồm 22 lô từ A01 – A22\n" +
                    "\n" +
                    "A01 – A11 thuộc mặt trong, diện tích 80m2 (5×16), hướng Nam, đường 7,5m, vỉa hè 3m\n" +
                    "A12 – A22 mặt đường đôi, diện tích 80m2 (5×16), hướng Bắc, mặt đường đại lộ Đông Tây\n" +
                    "Khu B: gồm 22 lô từ B01 – B22\n" +
                    "\n" +
                    "B01 – B08 thuộc mặt trong, diện tích 80m2 (5×16), hướng Nam, đường 7,5m, vỉa hè 3m\n" +
                    "B09 – B11 thuộc trục giữa, diện tích 85 – 97,5m2, hướng Đông, đường 7,5, vỉa hè 5m\n" +
                    "B12 – B22 mặt đường đại lộ Đông Tây, diện tích 80 – 107m2, hướng Bắc.\n" +
                    "Khu C: gồm 46 lô từ C01 – C46\n" +
                    "\n" +
                    "C01 – C23 mặt đường đại lộ Đông Tây, diện tích 80 – 107m2, hướng Bắc.\n" +
                    "C24 – C43 thuộc mặt trong, diện tích 80m2 (5×16), hướng Nam, đường 7,5m, vỉa hè 3m\n" +
                    "C44 – C46 thuộc trục giữa, diện tích 85 – 97,5m2, hướng Đông, đường 7,5, vỉa hè 5m\n" +
                    "Khu D: gồm 10 lô từ D01 – D10\n" +
                    "\n" +
                    "D01 – D10 mặt đường đại lộ Đông Tây, diện tích 79 – 92m2, hướng Bắc.",
            "Tòa nhà Bcons Tower VI là tòa văn phòng cho thuê tại TP. Dĩ An, Bình Dương, do Tập đoàn Bcons làm chủ đầu tư. Tòa nhà văn phòng Bcons Tower VI là sự tiếp nối của chuỗi sản phẩm văn phòng cho thuê chất lượng cao mang thương hiệu Bcons như: Bcons Tower I, Bcons Tower II, Bcons Tower III và Bcons Tower V.\n" +
                    "\n" +
                    "\n" +
                    "Phối cảnh tòa nhà Bcons Tower VI\n" +
                    "Vị trí\n" +
                    "Tòa nhà Bcons Tower VI tọa lạc tại đường số 3, khu phố Thống Nhất 1, phường Dĩ An, TP. Dĩ An, Bình Dương, ngay khu trung tâm hành chính TP. Dĩ An, với dân cư đông, nhịp sống sôi động, đầy đủ tiện ích lợi. Đáng chú ý, tòa văn phòng Bcons Tower VI nằm ngay kế bên chung cư Bcons Garden với hơn 1800 căn hộ, thuận tiện đáp ứng nhu cầu sinh hoạt và làm việc. Giao thông thuận lợi từ tòa văn phòng này đến các địa điểm nổi bật của Dĩ An và TP.HCM cũng là một điểm cộng lớn.\n" +
                    "\n" +
                    "2km đến KCN Sóng Thần\n" +
                    "Cách 2,5km đến TP. Thủ Đức\n" +
                    "4km đến Làng Đại học\n" +
                    "Thuận tiện di chuyển đến các quận nội thành TP.HCM\n" +
                    "Thiết kế - Tiện ích\n" +
                    "Quy mô tòa nhà văn phòng Bcons Tower VI gồm 5 tầng và 1 tầng hầm, với diện tích cho thuê trung bình khoảng 100m2, 200m2, 320m2,… đa dạng và linh hoạt theo nhu cầu của người thuê. Các tổ chức, doanh nghiệp lớn có thể thuê nhiều tầng hoặc thuê toàn bộ tòa nhà.\n" +
                    "\n" +
                    "Tòa văn phòng cho thuê Bcons Tower VI nổi bật với thiết kế màu trắng kết hợp cùng các đường viền cam kết hợp với những tấm kính cường lực tạo nên một tổng thể ấn tượng, tính thẩm mỹ cao. Mặt ngoài bằng kính giúp tòa nhà tràn ngập ánh sáng tự nhiên, tạo cảm giác thoáng đãng cho không gian làm việc. Ngoài ra, để tối ưu hóa không gian sử dụng, nhà thầu đã giảm thiểu số lượng cột bên trong sàn văn phòng, bảo đảm diện tích sử dụng trên mỗi sàn luôn được tối ưu, đồng thời giúp khách thuê dễ dàng thiết kế và trang trí không gian nội thất.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "Các công tác thiết kế và thi công tòa văn phòng Bcons Tower 6 đều do Tập đoàn Bcons thực hiện, bảo đảm các tiêu chí an toàn, chất lượng cũng như thẩm mỹ. Bên cạnh các lợi thế như vị trí thuận tiện giao thông, giá cho thuê cạnh tranh, thiết kế đẹp và hiện đại của Bcons Tower VI cũng là yếu tố khiến nhiều doanh nghiệp lựa chọn làm nơi đặt văn phòng.\n" +
                    "\n" +
                    "Một số thông tin về thiết kế, tiện ích tòa nhà Bcons Tower 6 Dĩ An:\n" +
                    "\n" +
                    "Quy mô: 5 tầng, 1 hầm\n" +
                    "Diện tích sàn: 300m2/sàn\n" +
                    "Chiều cao: 27m\n" +
                    "Thang máy: 1\n" +
                    "Khu đỗ xe: toàn bộ diện tích hầm\n" +
                    "Thời gian hoạt động: Từ 8h00-18h00 từ thứ 2 – thứ 6, 8h00 – 12h00 thứ 7\n" +
                    "\n",
            "Dự án The 5Way Phú Quốc (The 5Way Life Concepts) là khu căn hộ nằm trong khu phức hợp nghỉ dưỡng-giải trí Grand World Phú Quốc do Tập đoàn Vingroup phát triển. Phân khu The 5Way Phú Quốc gồm 10 block với tổng cộng hơn 10.000 căn hộ được thiết kế với concept độc đáo đi kèm hệ thống tiện ích cao cấp, thời thượng.\n" +
                    "\n" +
                    "\n" +
                    "Phối cảnh dự án The 5Way Phú Quốc\n" +
                    "Vị trí\n" +
                    "Dự án The 5Way Phú Quốc có vị trí tại Bãi Dài, Gành Dầu, TP. Phú Quốc, tỉnh Kiên Giang. Đây nổi tiếng là một trong những bãi biển đẹp nhất Việt Nam, với nước biển xanh trong, bãi cát trắng mịn dưới những hàng dừa, là điểm đến lý tưởng cho những kỳ nghỉ dưỡng, thư giãn. Căn hộ The 5 Way Phú Quốc là một phần thuộc tổ hợp Corona Resort & Casino Phú Quốc – casino đầu tiên tại Việt Nam mở cửa cho người Việt vui chơi, mang đến những trải nghiệm vui chơi, giải trí sôi động, đẳng cấp, hấp dẫn du khách và hứa hẹn tiềm năng sinh lời cho nhà đầu tư.\n" +
                    "\n" +
                    "Vị trí của căn hộ The 5Way Phú Quốc có lợi thế sau: \n" +
                    "\n" +
                    "Thuận tiện di chuyển đến các điểm du lịch và tiện ích khác tại đảo Phú Quốc\n" +
                    "Không gian nghỉ dưỡng yên tĩnh và riêng tư\n" +
                    "Nằm gần biển, thuận tiện cho các hoạt động vui chơi, giải trí biển\n" +
                    "\n" +
                    "Sơ đồ vị trí dự án The 5Way Phú Quốc",
            "Dự án Bcons Bình Thắng là sản phẩm mới nhất thuộc chuỗi dự án nhà ở vừa túi tiền tại Bình Dương của Tập đoàn Bcons. Tiếp nối loạt dự án căn hộ đã triển khai trước đó tại TP. Dĩ An, dự án Bcons được kỳ vọng sẽ mở ra nhiều cơ hội an cư cho người dân tại Dĩ An và lân cận. \n" +
                    "\n" +
                    "Dự án chung cư Bcons Bình Thắng dự kiến sẽ được ra mắt chính thức vào cuối năm 2023- đầu 2024. Dưới đấy là những thông tin sơ bộ đang được cập nhật về dự án này.\n" +
                    "\n" +
                    "\n" +
                    "Dự án Bcons Bình Thắng là khu chung cư tiếp theo được CĐT Bcons triển khai tại Dĩ An, Bình Dương (Ảnh minh họa)\n" +
                    "Vị trí\n" +
                    "Dự án căn hộ Bcons Bình Thắng nằm tại khu phố Hiệp Thắng, phường Bình Thắng, TP. Dĩ An, tỉnh Bình Dương, liền kề nhiều trục giao thông trọng điểm như: đường Mỹ Phước-Tân Vạn, Quốc lộ 1A, Võ Nguyên Giáp (Xa lộ Hà Nội cũ), thuận tiện kết nối liên vùng. Vị trí dự án Bcons Bình Thắng cũng gần ga Metro Bến Thành-Suối Tiên và bến xe Miền Đông mới, là những ưu điểm đáng chú ý về kết nối giao thông.\n" +
                    "\n" +
                    "Chung cư Bcons Bình Thắng tọa lạc gần Làng Đại học - khu vực tập trung của hàng chục ngàn sinh viên, giảng viên đang học tập và làm việc nên nhu cầu thuê và mua nhà ở luôn cao, là yếu tố tạo nên tiềm năng đầu tư cho thuê và bán lại cho căn hộ dự án.\n" +
                    "\n" +
                    "Tiện ích\n" +
                    "Tiện ích nội khu dự án Bcons Bình Thắng: đang cập nhật.\n" +
                    "\n" +
                    "Thiết kế\n" +
                    "Thiết kế căn hộ chung cư Bcons Bình Thắng: đang cập nhật.\n" +
                    "\n" +
                    "Tiến độ\n" +
                    "Ngày 26/8/2023, đại diện chủ đầu tư Bcons và nhà thầu đã tổ chức lễ động thổ nhà mẫu dự án Bcons Bình Thắng.\n" +
                    "\n" +
                    "Batdongsan.com.vn sẽ tiếp tục cập nhật những thông tin tiếp theo về dự án Bcons Bình Thắng trong thời gian tới.\n" +
                    "\n",
            "Centa River Park là phân khu đô thị nằm trong dự án Centa City, với vị trí đắc địa tại VSIP Bắc Ninh, TP. Từ Sơn, tỉnh Bắc Ninh. Đây được coi là phân khu được mong chờ nhất với tầm nhìn bao trọn sông Tào Khê và công viên trung tâm Centa City. Phân khu Centa River Park có quỹ căn số lượng giới hạn, chỉ 65 căn shophouse và biệt thự ven sông view công viên. \n" +
                    "\n" +
                    "Quý 3/2023, Centa River Park chuẩn bị được chủ đầu tư mở bán với nhiều chính sách ưu việt, đem đến cơ hội đầu tư sinh lời vượt bậc cùng các sản phẩm nhà hiện hữu đáp ứng nhu cầu ở - kinh doanh – cho thuê ngay.\n" +
                    "\n" +
                    "\n" +
                    "Phân khu Centa River Park thuộc khu đô thị Centa City Bắc Ninh\n" +
                    "Vị trí\n" +
                    "Phân khu Centa River Park nằm trong KĐT Centa City, thuộc Khu liên hợp đô thị - công nghiệp – dịch vụ VSIP Bắc Ninh, phường Phù Chẩn, Thành phố Từ Sơn, Bắc Ninh. Vị trí phân khu Centa River Park được đánh giá là đắc địa với view hướng ra dòng sông Tào Khê, đem đến không khí trong lành với không gian sống xanh lý tưởng.\n" +
                    "\n" +
                    "\n" +
                    "Sơ đồ vị trí KĐT Centa City\n" +
                    "Giá bán\n" +
                    "Chủ đầu tư Việt Nhân Bắc Ninh đang chuẩn bị mở bán Centa River Park - phân khu cuối cùng của dự án Centa City. Quỹ 65 căn mở bán đợt này có vị trí đắc địa, số lượng khan hiếm với chính sách ưu việt.\n" +
                    "\n" +
                    "Giá bán phân khu Centa River Park năm 2023: từ 7 tỷ/căn\n" +
                    "\n" +
                    "Chính sách bán hàng:\n" +
                    "\n" +
                    "Ân hạn lãi gốc 2 năm – đến cuối năm 2025\n" +
                    "CĐT chiết khấu lên đến 5%, tặng vàng\n" +
                    "Nhà hiện hữu, nhận nhà kinh doanh, cho thuê được ngay\n" +
                    "Tiện ích\n" +
                    "Nằm trong KĐT Centa City, phân khu Centa River Park sẽ được thừa hưởng đầy đủ hệ thống tiện ích nội khu cực kỳ đa dạng, tiện nghi ở đây. Các tiện ích tiêu biểu gồm có:\n" +
                    "\n" +
                    "Công viên hồ điều hoà trung tâm rộng 1,4ha, có khu vui chơi trẻ em Centa Kid, quán café, rạp chiếu phim, phố ẩm thực Centa Food - nơi thường xuyên tổ chức các sự kiện ca nhạc hàng tuần\n" +
                    "Công viên bờ sông Tào Khê\n" +
                    "Trường mầm non Chim Chích Bông\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    " \n" +
                    "Thiết kế\n" +
                    "Với tổng diện tích 2,7ha, phân khu Centa River Park gồm 65 căn shophouse và biệt thự đơn lập.\n" +
                    "\n" +
                    "Chi tiết thiết kế các sản phẩm tại phân khu Centa River Park:\n" +
                    "\n" +
                    "Shophose Centa River Park:  diện tích đất 90m2, xây dựng 60m2, 3 tầng 1 tum. Tổng diện tích sử dung 188m2.\n" +
                    "Biệt thự đơn lập – 1: diện tích đất 216m2, xây dựng 64m2, 3 tầng 1 tum. Tổng DTSD 197m2.\n" +
                    "Biệt thự đơn lập – 2:  diện tích đất 240m2, xây dựng 72m2, 3 tầng 1 tum. Tổng DTSD 222m2.\n" +
                    "Hình ảnh thực tế:\n"
        )
        var arr = emptyList<Project>()
        for (i in 0..4) {
            val p = Project()
            p.projectName = name[i]
            p.projectDescription = des[i]
            arr = arr.plus(p)
        }
        return arr
    }

    fun gHouse() : List<House> {
        val des = "Thông tin mô tả\n" +
                    "* Nhà nội thất cơ bản + rèm (Hỗ trợ thương lượng gắn thêm máy lạnh, thiết bị điện tử).\n" +
                    "\n" +
                    "- 2 phòng ngủ, 2 toilets từ 6 triệu/tháng.\n" +
                    "- 3 phòng ngủ, 2 toilets: 10 - 12 triệu/tháng.\n" +
                    "\n" +
                    "* Tiện ích tiện lợi 3 tầng trung tâm thương mại - gym, hồ bơi, khu vui chơi trẻ em, game,...\n" +
                    "\n" +
                    "Cam kết hỗ trợ.\n" +
                    "- Giỏ hàng căn hộ cần cho thuê chính chủ và giá được thương lượng đúng với thị trường.\n" +
                    "- Hỗ trợ mọi thủ tục giấy tờ cư dân nhanh chóng.\n" +
                    "- Đội ngũ dọn vệ sinh, dọn nhà trọn gói, internet, nội thất,...\n" +
                    "Luôn đồng hành cùng quý anh/chị trong suốt quá trình thuê nhà."
        var arr = emptyList<House>()
        for (i in 0..4) {
            val h = House()
            h.displayName = "Căn hộ Q${i + 1} Riverside"
            h.description = des
            h.email = gAccount()
            h.infor = gHouseInfo()[i]
            h.address = gAddress()[i]
            h.createTime = BigDecimal(Date().time + i * 1000)
            h.project = gProject()[i]
            arr = arr.plus(h)
        }
        return arr
    }

    fun gHouseInfo() : List<HouseInfo> {
        var arr = emptyList<HouseInfo>()
        for (i in 0..4) {
            val hi = HouseInfo()
            hi.thumbNailUrl = "https://file4.batdongsan.com.vn/2023/04/17/20230417230202-3438_wm.jpg"
            hi.numKitchen = 1
            hi.houseTypeDetailHouseTypes = gHouseType().toMutableSet()
            hi.numBathroom = 2
            hi.numToilet = 2
            hi.numLivingRoom = 1
            hi.numBedRoom = 3
            arr = arr.plus(hi)
        }
        return arr
    }

//    fun gHouseImage() : List<HouseImages> {
//        var arr = emptyList<HouseImages>()
//        for (house in houses) {
//            var i = 0
//            val x = listOf(
//                "https://file4.batdongsan.com.vn/2023/04/17/20230417230210-69b7_wm.jpg",
//                "https://file4.batdongsan.com.vn/2023/04/17/20230417230218-7f65_wm.jpg",
//                "https://file4.batdongsan.com.vn/2023/04/17/20230417230207-a221_wm.jpg",
//                "https://file4.batdongsan.com.vn/2023/04/17/20230417230207-a221_wm.jpg",
//                "https://file4.batdongsan.com.vn/2023/04/17/20230417230205-1b13_wm.jpg",
//            ).map {
//                val houseImages = HouseImages()
//                houseImages.imageUrl = it
//                houseImages.houseImageHouseInfos = house.infor
//                houseImages
//            }
//            arr = arr.plus(x)
//        }
//        return arr
//    }

    fun gHouseType() : List<HouseType> {
        val bans = HouseType()
        bans.typeName = "Sell"
        bans.price = BigDecimal(10_000_000_000)
        val thue = HouseType()
        thue.typeName = "Rent"
        thue.price = BigDecimal(10_000_000)
        return listOf(
            bans,
            thue
        )
    }
}