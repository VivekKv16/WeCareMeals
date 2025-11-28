
package com.wecaremeals.dao;

import java.util.List;
import com.wecaremeals.dto.Donation;

public interface DonationDAO {
    List<Donation> getDonationsForNgo(int ngoId);
}
